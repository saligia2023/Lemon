<template>
  <div>

    <!--      <el-col :span="8" style="padding: 10px">-->
    <!--        <el-card style="height: 330px">-->
    <!--          <div class="user">-->
    <!--            <img src="../assets/images/profile.jpg" alt="">-->
    <!--            <div class="userinfo">-->
    <!--              <p class="name">{{ user.userName }}</p>-->
    <!--              <p class="access">{{ roleGroup }}</p>-->
    <!--            </div>-->
    <!--          </div>-->
    <!--          <div>-->
    <!--            <div class="logininfo">-->
    <!--              <p>上次登录时间：<span>{{ lastUpdatedTime }}</span></p>-->
    <!--              <p>上次登录地址：<span>扬州</span></p>-->
    <!--            </div>-->
    <!--          </div>-->
    <!--        </el-card>-->
    <!--        <el-card style="margin-top: 20px;height: 510px">-->
    <!--          <el-table-->
    <!--            :data="tableData"-->
    <!--            style="width: 100%">-->
    <!--            <el-table-column-->
    <!--              prop="name"-->
    <!--              label="优秀员工"-->
    <!--              width="140">-->
    <!--            </el-table-column>-->
    <!--            <el-table-column-->
    <!--              prop="age"-->
    <!--              label="年龄"-->
    <!--              width="140">-->
    <!--            </el-table-column>-->
    <!--            <el-table-column-->
    <!--              width="150"-->
    <!--              prop="position"-->
    <!--              label="职位">-->
    <!--            </el-table-column>-->
    <!--          </el-table>-->
    <!--        </el-card>-->
    <!--      </el-col>-->
      <div id="app">
    <el-row>
    <el-col :span="24" style="padding: 10px">

      <div class="graph">
        <!--      饼图-->
        <el-card :span="7" style="width: 50%;height:400px">
          <div ref="box" style="height: 390px" ></div>
        </el-card>
        <!--      饼1-->
        <el-card :span="7" style="width: 49%;height:400px">
          <div ref="boxpie" style="height: 390px"></div>
        </el-card>
      </div>
      <div style="padding-top: 10px">
        <!--      折线图-->
        <el-card style="height: 300px; padding-top: 10px">
          <div style="height: 220px;width: 1500px;" ref="zx"></div>
        </el-card>
      </div>
      <div>
        <!-- 柱状图2 -->
        <el-card style="height: 400px; margin-top: 10px;">
          <div style="height: 350px; width: 1500px;" ref="zzt"></div>
        </el-card>
      </div>

      <div>
        <!-- 折线图2 -->
        <el-card style="height: 400px; margin-top: 20px;">
          <div style="height: 350px; width: 1500px;" ref="zxt"></div>
        </el-card>
      </div>
    </el-col>
  </el-row>

      </div>
</div>
</template>


<script>
import '@/assets/echarts/macarons.js';
// import {getData} from "@/api/monitor";
import { getUserProfile } from "@/api/system/user";
export default {
mounted() {
  // this.getUser();
  this.showEcarts();
  // this.currentTime = this.formatDate(new Date());
  // setInterval(() => {
  //   this.currentTime = this.formatDate(new Date());
  // }, 1000);
  // getData().then((data) => {
  //   console.log(data)
  // })
},

// data() {
//   return {
//     user: {},
//     roleGroup: {},
//     currentTime: '',
//     lastUpdatedTime: '',
//     tableData: [{
//       age: '21',
//       name: '杨弈航',
//       position: '市场营销部小组组长'
//     }, {
//       age: '21',
//       name: '冯永鑫',
//       position: '人力资源部干事'
//     }, {
//       age: '22',
//       name: '易俊',
//       position: '运营部成员'
//     }, {
//       age: '20',
//       name: '王永涛',
//       position: '技术部小组组长'
//     },
//       {
//         age: '21',
//         name: '滕召扬',
//         position: '财务部干事'
//       },
//       ]
//   }
// },

methods: {
  // getUser() {
  //   getUserProfile().then(response => {
  //     this.user = response.data;
  //     this.roleGroup = response.roleGroup;
  //     this.lastUpdatedTime = this.formatDate(new Date());  // 更新时间
  //   });
  // },
  // formatDate(date) {
  //   return date.getFullYear() + '-' +
  //     (date.getMonth() + 1).toString().padStart(2, '0') + '-' +
  //     date.getDate().toString().padStart(2, '0') + ' ' +
  //     date.getHours().toString().padStart(2, '0') + ':' +
  //     date.getMinutes().toString().padStart(2, '0') + ':' +
  //     date.getSeconds().toString().padStart(2, '0');
  // },
  showEcarts() {
    // 基于准备好的dom，初始化echarts实例
    const mycart = this.$echarts.init(this.$refs.box, 'macarons')
    //绘制图表
    const option = {
      title: { // 添加标题
        text: '招聘技能占比',
        left: 'center',

      },
      toolbox: {
        show: true,
        feature: {
          mark: { show: true },
          dataView: { show: true, readOnly: false },
          restore: { show: true },
          saveAsImage: { show: true }
        }
      },
      series: [
        {
          name: 'Nightingale Chart',
          type: 'pie',
          radius: [25, 125],
          center: ['50%', '50%'],
          roseType: 'area',
          itemStyle: {
            borderRadius: 8
          },
          data: [
            { value: 40, name: '精通外语' },
            { value: 38, name: '精通JAVA编程' },
            { value: 32, name: '精通PYTHON编程' },
            { value: 30, name: '精通网络安全技术' },
            { value: 28, name: '精通安全防护作业' },
            { value: 26, name: '精通漏洞评估' },
            { value: 22, name: '精通框架应用' }
          ]
        }
      ]
    };
    mycart.setOption(option)

    //折线图
    const myzx = this.$echarts.init(this.$refs.zx, 'macarons')
    myzx.setOption( {
        title: {
          text: '应聘渠道'
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: ['Boss直聘', '58同城', '内部推荐', '赶集直招', '校园招聘']
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
          data: ['5.28', '5.29', '5.30', '5.31', '6.1', '6.2', '6.3','6.4']
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            name: 'Boss直聘',
            type: 'line',
            data: [[0, 1], [1, 5], [2, 2], [3, 2], [4, 1], [5, 3], [6, 4], [7, 2]]
          },
          {
            name: '58同城',
            type: 'line',
            data: [[0, 10], [1, 6], [2, 19], [3, 12], [4, 19], [5, 13], [6, 5], [7, 3]]
          },
          {
            name: '内部推荐',
            type: 'line',
            data: [[0, 15], [1, 14], [2, 23], [3, 20], [4, 15], [5, 19], [6, 33], [7, 15]]
          },
          {
            name: '赶集直招',
            type: 'line',
            data: [[0, 30], [1, 25], [2, 24], [3, 15], [4, 17], [5, 16], [6, 27], [7, 26]]
          },
          {
            name: '校园招聘',
            type: 'line',
            data: [[0, 25], [1, 14], [2, 8], [3, 19], [4, 11], [5, 25], [6, 14], [7, 13]]
          },
        ]
      }
    );

//柱状图2
    const myzzt = this.$echarts.init(this.$refs.zzt, 'macarons')
    myzzt.setOption({
      title: { // 添加标题
        text: '职员需求图',
        left: 'left',
      },
      tooltip: {
        trigger: 'axis',
        axisPointer: {
          type: 'shadow'
        }
      },
      legend: {
        data: ['预期', '差值', '实际'] // 添加新系列的名称
      },
      grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
      },
      xAxis: [
        {
          type: 'value'
        }
      ],
      yAxis: [
        {
          type: 'category',
          axisTick: {
            show: false
          },
          data: ['数据分析师', '销售经理', '财务经理', '人力资源经理', '公关人员', '客服代表', '人事专员','UI设计师']
        }
      ],
      series: [
        {
          name: '实际',
          type: 'bar',
          label: {
            show: true,
            position: 'inside'
          },
          emphasis: {
            focus: 'series'
          },
          data: [2, 4, 3, 4, 4, 10, 10,3]
        },

        {
          name: '差值',
          type: 'bar',
          stack: 'Total',
          label: {
            show: true,
            position: 'left'
          },
          emphasis: {
            focus: 'series'
          },
          data: [-3, -6, -7, -4, -4, -5, -5,-3]
        },
        {
          name: '预期', // 新增系列的名称
          type: 'bar', // 新增系列的类型为柱形图
          label: {
            show: true
          },
          emphasis: {
            focus: 'series'
          },
          data: [5, 10, 10, 8, 8, 15, 15,6] // 新增系列的数据
        }
      ]
      }
    );
  //折线图2
    const myzxt = this.$echarts.init(this.$refs.zxt, 'macarons');
    myzxt.setOption(
      {
        title: {
          text: '预测录用比'
        },
        tooltip: {
          trigger: 'axis'
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
          data: ['5.27','5.28', '5.29', '5.30', '5.31', '6.1', '6.2', '6.3']
        },
        yAxis: {
          type: 'value',
          min: 0,
          max: 2.0,
          interval: 0.2

        },
        series: [
          {
            name: '比值',
            type: 'line',
            smooth: false,
            stack: 'Total',
            data: [0.6, 0.84, 0.72, 1.43, 1.76, 0.44, 0.91,1.1]
          },

        ]
    })
    //饼图
    const mypie = this.$echarts.init(this.$refs.boxpie, 'macarons');
    mypie.setOption({
      title: { // 添加标题
        text: '年龄占比分布图',
        left: 'center',

      },
      tooltip: {
        trigger: 'item'
      },
      legend: {
        show: false // 不显示图例
      },
      series: [{
        name: 'Access From',
        type: 'pie',
        radius: ['35%', '65%'],
        avoidLabelOverlap: false,
        itemStyle: {
          borderRadius: 10,
          borderColor: '#fff',
          borderWidth: 2
        },
        label: {
          show: true,
          formatter: '{b}', // 只显示名称
          position: 'outside'
        },
        emphasis: {
          label: {
            show: true,
            fontSize: 40,
            fontWeight: 'bold'
          }
        },
        labelLine: {
          show: true
        },
        data: [
          {value: 1048, name: '20~24'},
          {value: 735, name: '24~28'},
          {value: 580, name: '28~30'},
          {value: 484, name: '30~35'},
          {value: 300, name: '35+'}
        ]
      }]
    });

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
  margin-left: 100px;
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
