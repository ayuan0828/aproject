package exercises

import scala.collection.immutable
import scala.io.Source

object a {
  def main(args: Array[String]): Unit = {
    //1.清洗数据
    //  1.1 读取网站的日志文件
    val visitorValue: Iterator[String] = Source.fromFile("src\\a.csv").getLines()
    //  1.2 过滤不满足条件的日志记录 (站点,用户名,日期)
    val cleanVisitorValue : Iterator[String] =visitorValue.filter(data=>{
      val result :Array[String] =data.split(",")
      result.length>=14 && !result.exists(x=>x.isEmpty)})
     /*for(i <- cleanVisitorValue){
       println(i)
     }*/
    //2.将清洗后的数据转换为集合
    var visitorValueSplit: Iterator[Array[String]] = cleanVisitorValue.map(x => x.split(","))
    // 2.1 Iterator(("site1","user1","2018-03-01","02:12:22),("site1"....))
    var visitorTupple: Iterator[(String, String, String, String)] = visitorValueSplit.map(data => {
      (data(1), data(8), data(4),data(9))
    })

    //2.2 visitorTupple转换为List集合
    var lisData: List[(String, String, String, String)] = visitorTupple.toList
    /*for(i <- lisData){
      println(i)
    }*/
    //3.实现统计分析
    //  3.1 统计每天每个网站的访问量 group by.. （网址,日期）
    //       ((site3,2018-03-05),List((site3,user6,2018-03-05,09:12:22),
    //       (site3,user6,2018-03-05,10:12:22), (site3,user6,2018-03-05,08:12:22)))
    var visitorGroupBy: Map[String, List[(String, String, String, String)]] =
    lisData.groupBy(x => x._3)
    //visitorGroupBy.foreach(println)
    //  3.2 统计分析
    var result: immutable.Iterable[(String, Int)] = visitorGroupBy.map(data => {
      // 访问网址的日期
      val movieid: (String) = data._1
      // 每个电影的访问量
      val pv: Int = data._2.size
      (movieid, pv)
    })

    result.foreach(println)

  }



}
