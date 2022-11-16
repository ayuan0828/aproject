import scala.collection.immutable
import scala.io.Source

object Moviezong {
  def main(args: Array[String]): Unit = {
    //1.清洗数据
    //  1.1 读取文件
    val visitorValue: Iterator[String] = Source.fromFile("src\\input\\DMSC.csv").getLines()
    //  1.2 过滤不满足条件的记录
    val cleanVisitorValue: Iterator[String] = visitorValue.filter(data => {
      val result: Array[String] = data.split(",")
      result.length >= 10 && !result.exists(x => x.isEmpty) && data.startsWith("ID") == false
    })
    /*for(i <- cleanVisitorValue){
      println(i)
    }*/
    //2.将清洗后的数据转换为集合
    var visitorValueSplit: Iterator[Array[String]] = cleanVisitorValue.map(x => x.split(","))
    var visitorTupple: Iterator[(String, String)] = visitorValueSplit.map(data => {
      (data(2), data(7))
    })

    //2.2 visitorTupple转换为List集合
    var lisData: List[(String, String)] = visitorTupple.toList
    /*for(i <- lisData){
      println(i)
    }*/
    //3.实现统计分析
    //  3.1 统计每个电影的点评量 group by..
    var visitorGroupBy: Map[String, List[(String, String)]] =
    lisData.groupBy(x => x._1)
    //visitorGroupBy.foreach(println)
    //  3.2 统计分析
    var result: immutable.Iterable[(String, Int)] = visitorGroupBy.map(data => {
      // 电影名
      val movieid: (String) = data._1
      // 每个电影的点评量
      val pv: Int = data._2.size
      (movieid, pv)
    })

    result.foreach(println)

  }


}
