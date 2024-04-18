<template>
  <div>
    <el-row>
      <el-col :span="8" style="padding: 10px">
        <el-card style="height: 330px">
          <div class="user">
            <img src="../assets/images/profile.jpg" alt="">
            <div class="userinfo">
              <p class="name">Admin</p>
              <p class="access">管理员</p>
            </div>
          </div>
          <div>
            <div class="logininfo">
              <p>上次登录时间：<span>2024-4-18</span></p>
              <p>上次登录地址：<span>扬州</span></p>
            </div>
          </div>
        </el-card>
        <el-card style="margin-top: 20px;height: 510px">
          <el-table
            :data="tableData"
            style="width: 100%">
            <el-table-column
              prop="name"
              label="优秀员工"
              width="140">
            </el-table-column>
            <el-table-column
              prop="age"
              label="年龄"
              width="140">
            </el-table-column>
            <el-table-column
              width="150"
              prop="position"
              label="职位">
            </el-table-column>
          </el-table>
        </el-card>
      </el-col>

      <el-col :span="16" style="panding: 10px">

        <div class="graph">
          <!--      饼图-->
          <el-card :span="7" style="width: 49%;height:250px">
            <div ref="box" style="height: 260px" ></div>
          </el-card>
          <!--      柱状图1-->
          <el-card :span="7" style="width: 49%;height:250px">
            <div ref="boxpie" style="height: 260px"></div>
          </el-card>
        </div>
        <div style="padding-top: 10px">
          <!--      折线图-->
          <el-card style="height: 300px; padding-top: 10px">
            <div style="height: 220px" ref="zx"></div>
          </el-card>
        </div>
        <div>
          <!--      柱状图2-->
          <el-card style="height: 290px;margin-top: 10px">
            <div style="height: 220px" ref="zzt"></div>
          </el-card>
        </div>
      </el-col>
    </el-row>



  </div>
</template>


<script>
import '@/assets/echarts/macarons.js';
// import {getData} from "@/api/monitor";

export default {
  mounted() {
    // 挂在完成dom后进行初始化
    this.showEcarts();
    getData().then((data) => {
      console.log(data)
    })
  },

  data() {
    return {
      tableData: [{
        age: '21',
        name: '杨弈航',
        position: '市场营销部小组组长'
      }, {
        age: '21',
        name: '冯永鑫',
        position: '人力资源部干事'
      }, {
        age: '22',
        name: '易俊',
        position: '运营部成员'
      }, {
        age: '20',
        name: '王永涛',
        position: '技术部小组组长'
      },
        {
          age: '21',
          name: '滕召扬',
          position: '财务部干事'
        },
        ]
    }
  },

  methods: {
    showEcarts() {
      // 基于准备好的dom，初始化echarts实例
      const mycart = this.$echarts.init(this.$refs.box,'macarons')
      //绘制图表
      const option = {
        xAxis: {
          type: 'category',
          data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            data: [120, 200, 150, 80, 70, 110, 130],
            type: 'bar',
            showBackground: true,
            backgroundStyle: {
              color: 'rgba(180, 180, 180, 0.2)'
            }
          }
        ]
      };
      mycart.setOption(option)

      //折线图
      const myzx = this.$echarts.init(this.$refs.zx,'macarons')
      myzx.setOption({
        title: {
          text: 'Stacked Line'
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: ['Email', 'Union Ads', 'Video Ads', 'Direct', 'Search Engine']
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        toolbox: {
          feature: {
            saveAsImage: {}
          }
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            name: 'Email',
            type: 'line',
            stack: 'Total',
            data: [120, 132, 101, 134, 90, 230, 210]
          },
          {
            name: 'Union Ads',
            type: 'line',
            stack: 'Total',
            data: [220, 182, 191, 234, 290, 330, 310]
          },
          {
            name: 'Video Ads',
            type: 'line',
            stack: 'Total',
            data: [150, 232, 201, 154, 190, 330, 410]
          },
          {
            name: 'Direct',
            type: 'line',
            stack: 'Total',
            data: [320, 332, 301, 334, 390, 330, 320]
          },
          {
            name: 'Search Engine',
            type: 'line',
            stack: 'Total',
            data: [820, 932, 901, 934, 1290, 1330, 1320]
          }
        ]
      });

//柱状图2
      const myzzt = this.$echarts.init(this.$refs.zzt,'macarons')
      myzzt.setOption({
        title: {
          text: 'World Population'
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          }
        },
        legend: {},
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: {
          type: 'value',
          boundaryGap: [0, 0.01]
        },
        yAxis: {
          type: 'category',
          data: ['Brazil', 'Indonesia', 'USA', 'India', 'China', 'World']
        },
        series: [
          {
            name: '2011',
            type: 'bar',
            data: [18203, 23489, 29034, 104970, 131744, 630230]
          },
          {
            name: '2012',
            type: 'bar',
            data: [19325, 23438, 31000, 121594, 134141, 681807]
          }
        ]
      });

      //饼图
      const mypie = this.$echarts.init(this.$refs.boxpie,'macarons')
      mypie.setOption({
        title: {
          text: 'Resume age ratio',
          left: 'center'
        },
        tooltip: {
          trigger: 'item'
        },
        legend: {
          orient: 'vertical',
          left: 'left'
        },
        series: [
          {
            name: 'Access From',
            type: 'pie',
            radius: '50%',
            data: [
              { value: 51, name: '20~24' },
              { value: 21, name: '24~28' },
              { value: 33, name: '28~35' },
              { value: 18, name: '35~40' },
              { value: 11, name: '40+' }
            ],
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      })
    },
  },
}
</script>
<style scoped>
.user{
  padding-bottom: 20px;
  margin-bottom: 20px;
  border-bottom: 1px solid #888a8e;
  display: flex;
  img{
    margin-right: 40px;
    width: 150px;
    height: 150px;
    border-radius:50%;
  }
}
.userinfo{
  .name{
    font-size: 32px;
    margin-bottom: 10px;
  }
  .access{

    color: #999999;
  }

}
.logininfo{
  p{
    line-height: 28px;
    font-size: 14px;
    color: #999999;
  }
  span{
    margin-left: 60px;
    color: #666666;
  }
}
.echart-box{
  width: 500px;
  height: 260px;
  margin: 1px ;
}
.graph{
  padding-top: 10px;
  display: flex;
  justify-content: space-between;
}
</style>
