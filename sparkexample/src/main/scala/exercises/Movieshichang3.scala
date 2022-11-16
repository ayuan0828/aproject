
package exercises

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._

import java.io.PrintWriter


object Movieshichang3 {
  def main(args: Array[String]): Unit = {
    //1.加载Spark配置环境
    val conf = new SparkConf().setAppName("AnalyzeMovie").setMaster("local")
    //2. 获取Spark上下文对象
    val sc = new SparkContext(conf);

    val inputFile = "src\\doubanmei1.csv"
    val outputFile = "src\\output\\movieshi3.json"
    //3. 读取存放电影信息的文件
    val csv = sc.textFile(inputFile)
    val clean= csv.filter(x=>{
      val result :Array[String] =x.split(",")
      result.length>=4 && !result.exists(x=>x.isEmpty)

    })
    var star = clean.map{x =>
      val line = x.split(",")
      (line(1).toInt)
    }

    val result = star.filter(x=>(x<=60)).map(y => ("0-60",1)).reduceByKey(_ + _)
      .union(
        star.filter(x => (x>60 && x<=90)).map(y => ("60-90",1)).reduceByKey(_ + _))
      .union(
        star.filter(x =>(x>90 && x<=120)).map(y => ("90-120",1)).reduceByKey(_ + _)
      )
      .union(star.filter(x => (x>120 && x<=150)).map(y => ("120-150",1)).reduceByKey(_ + _))
      .union(star.filter(x => (x>150 && x<=180)).map(y => ("150-180",1)).reduceByKey(_ + _))
      .union(star.filter(x => (x>180)).map(y => ("180-",1)).reduceByKey(_ + _))

    result.foreach(println)
    rddToJson(result,outputFile)

  }

  def rddToJson(rateRdd:RDD[(String,Int)],outputFilePath :String)={
    //1.将分析结果转换为json格式的数据
    val result = "data" -> rateRdd.collect().toList.map{
      case (a,b) =>
        ("shichang",a) ~
          ("count",b)
    }
    //2.将转换后的数据写入到文件中
    val outputFile =  new PrintWriter(outputFilePath)
    //把json对象转换为字符串，并压缩显示
    outputFile.write(compact(render(result)))
    outputFile.close()
  }
}