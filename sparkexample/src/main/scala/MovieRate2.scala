import java.io.PrintWriter
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._

//统计大鱼海棠电影的1到5评分人数
object MovieRate2 {

  def main(args: Array[String]): Unit = {
    //1.加载Spark配置环境
    val conf = new SparkConf().setAppName("AnalyzeMovie2").setMaster("local")
    //2. 获取Spark上下文对象
    val sc = new SparkContext(conf);

    val inputFile = "src\\input\\moviedayu.csv"
    val outputFile = "src\\main\\resources\\static\\data\\movierate2.json"
    //3. 读取存放电影信息的文件
    val csv = sc.textFile(inputFile)
    val clean = csv.filter(x => {
      val result: Array[String] = x.split(",")
      result.length >= 10 && !result.exists(x => x.isEmpty) && x.startsWith("ID") == false

    })
    var age = clean.map { x =>
      val line = x.split(",")
      (line(7).toInt)
    }

    val result = age.filter(x => (x == 1)).map(y => ("评分为1", 1)).reduceByKey(_ + _)
      .union(
        age.filter(x => (x == 2)).map(y => ("评分为2", 1)).reduceByKey(_ + _))
      .union(
        age.filter(x => (x == 3)).map(y => ("评分为3", 1)).reduceByKey(_ + _)
      )
      .union(age.filter(x => (x == 4)).map(y => ("评分为4", 1)).reduceByKey(_ + _))
      .union(age.filter(x => (x == 5)).map(y => ("评分为5", 1)).reduceByKey(_ + _))

    result.foreach(println)
    rddToJson(result, outputFile)

  }

  def rddToJson(rateRdd: RDD[(String, Int)], outputFilePath: String) = {
    //1.将分析结果转换为json格式的数据
    val result = "data" -> rateRdd.collect().toList.map {
      case (a, b) =>
        ("rate", a) ~
          ("count", b)
    }
    //2.将转换后的数据写入到文件中
    val outputFile = new PrintWriter(outputFilePath)
    //把json对象转换为字符串，并压缩显示
    outputFile.write(compact(render(result)))
    outputFile.close()

  }
}
