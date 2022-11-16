
$.getJSON("http://127.0.0.1:8082/static/data/agestage.json", function(data) {
    var json = data;
    console.log(json.age);
    var xAxis=[]
    var yAxis=[]
    for(var i=0;i<json.data.length;i++){
        xAxis.push(json.data[i].agestage);
        yAxis.push(json.data[i].count);
    }
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('userage'), 'dark');

    const labelRight = {
        position: 'right'
    };
   option = {
    backgroundColor: '#483d8b',
    title: {
        text: '用户年龄',
        subtext: '从图中可以看出25岁左右的听众数量最多，其中28岁可能是系统默认',
        // x: 'center'
        x: 'left'
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {            // 坐标轴指示器，坐标轴触发有效
            type: 'line'        // 默认为直线，可选为：'line' | 'shadow'
        }
    },
    xAxis: {
        type: 'category',
        data: xAxis
    },
    yAxis: {
        type: 'value'
    },
    series: [{
        data: yAxis,
        type: 'bar'
    }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
})

