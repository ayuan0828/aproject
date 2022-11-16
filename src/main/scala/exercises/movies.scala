package exercises

import scala.collection.immutable
import scala.io.Source

object movies {
  def main(args: Array[String]): Unit = {
    //在scala程序中以行的形式导入文件
    val visitorValue: Iterator[String] = Source.fromFile("src\\movies.csv").getLines()
    //a.csv为comments.csv文件中截取的一部分
    val visitorValue1: Iterator[String] = Source.fromFile("src\\a.csv").getLines()

    val cleanVisitorValue : Iterator[String] =visitorValue.filter(data=>{
      val result :Array[String] =data.split(",")
      !result.exists(x=>x.isEmpty)})
    /*for(i <- cleanVisitorValue){
      println(i)
    }*/
    var visitorValueSplit: Iterator[Array[String]] = cleanVisitorValue.map(x => x.split(","))
    var visitorTupple: Iterator[(String, String)] = visitorValueSplit.map(data => {
      (data(0), data(1))
    })
    var movie = visitorTupple.toMap
    /*for(i <- lisData){
      println(i)
    }*/


    val cleanVisitorValue1 : Iterator[String] =visitorValue1.filter(data=>{
      val result :Array[String] =data.split(",")
      result.length>=14 && !result.exists(x=>x.isEmpty)})
    /*for(i <- cleanVisitorValue1){
      println(i)
    }*/
    var visitorValueSplit1: Iterator[Array[String]] = cleanVisitorValue1.map(x => x.split(","))
    var visitorTupple1: Iterator[(String, String, String, String)] = visitorValueSplit1.map(data => {
      (data(1), data(8), data(4),data(9))
    })

    //2.2 visitorTupple转换为List集合
    var lisData1: List[(String, String, String, String)] = visitorTupple1.toList


    var visitorGroupBy1: Map[String, List[(String, String, String, String)]] =
    lisData1.groupBy(x => x._3)
    //visitorGroupBy.foreach(println)
    //  3.2 统计分析
    var result: immutable.Iterable[(Int,String)] = visitorGroupBy1.map(data => {
      // 电影id
      val movieid: (String) = data._1
      // 每个电影的点评量
      val pv: Int = data._2.size
      (pv,movieid)
    })

    var rating = result.toList
    //rating.foreach(println)


    var movieJoinCustomer: List[(String, String, Int)] = rating.map(data => {
      //
      val result1 :String = movie.getOrElse(data._2, null)
      //为元组
      (result1, data._2, data._1)
    })

    movieJoinCustomer.foreach(println)
  }

}
