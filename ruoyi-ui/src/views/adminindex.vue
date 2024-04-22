<template>
  <div>
    <el-row>
      <el-col :span="8" style="padding: 10px">
        <el-card style="height: 330px">
          <div class="user">
            <img src="../assets/images/profile.jpg" alt="">
            <div class="userinfo">
              <p class="name">{{ user.userName }}</p>
              <p class="access">{{ roleGroup }}</p>
            </div>
          </div>
          <div>
            <div class="logininfo">
              <p>上次登录时间：<span>{{ lastUpdatedTime }}</span></p>
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
import { getUserProfile } from "@/api/system/user";
export default {
  mounted() {
    this.getUser();
    this.showEcarts();
    this.currentTime = this.formatDate(new Date());
    setInterval(() => {
      this.currentTime = this.formatDate(new Date());
    }, 1000);
    getData().then((data) => {
      console.log(data)
    })
  },

  data() {
    return {
      user: {},
      roleGroup: {},
      currentTime: '',
      lastUpdatedTime: '',
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
    getUser() {
      getUserProfile().then(response => {
        this.user = response.data;
        this.roleGroup = response.roleGroup;
        this.lastUpdatedTime = this.formatDate(new Date());  // 更新时间
      });
    },
    formatDate(date) {
      return date.getFullYear() + '-' +
        (date.getMonth() + 1).toString().padStart(2, '0') + '-' +
        date.getDate().toString().padStart(2, '0') + ' ' +
        date.getHours().toString().padStart(2, '0') + ':' +
        date.getMinutes().toString().padStart(2, '0') + ':' +
        date.getSeconds().toString().padStart(2, '0');
    },
    showEcarts() {
      // 基于准备好的dom，初始化echarts实例
      const mycart = this.$echarts.init(this.$refs.box, 'macarons')
      //绘制图表
      const option = {
        title: {
          text: '招聘技能占比',
          subtext: '',
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
              { value: 1048, name: '熟悉框架' },
              { value: 735, name: '精通网络安全技术' },
              { value: 580, name: '精通JAVA' },
              { value: 484, name: '精通外语' },
              { value: 300, name: '精通网络安全工具' }
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
      };
      mycart.setOption(option)

      //折线图
      const myzx = this.$echarts.init(this.$refs.zx, 'macarons')
      myzx.setOption( {
        title: {
          text: '候选人渠道'
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
          data: ['4.1', '4.4', '4.7', '4.10', '4.13', '4.16', '4.19']
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            name: 'Boss直聘',
            type: 'line',
            data: [[0, 1], [1, 5], [2, 2], [3, 2], [4, 1], [5, 3], [6, 4]]
          },
          {
            name: '58同城',
            type: 'line',
            data: [[0, 10], [1, 6], [2, 19], [3, 12], [4, 19], [5, 13], [6, 5]]
          },
          {
            name: '内部推荐',
            type: 'line',
            data: [[0, 15], [1, 14], [2, 23], [3, 20], [4, 15], [5, 19], [6, 33]]
          },
          {
            name: '赶集直招',
            type: 'line',
            data: [[0, 30], [1, 25], [2, 24], [3, 15], [4, 17], [5, 16], [6, 27]]
          },
          {
            name: '校园招聘',
            type: 'line',
            data: [[0, 25], [1, 14], [2, 8], [3, 19], [4, 11], [5, 25], [6, 14]]
          },
        ]
      }
    );

//柱状图2
      const myzzt = this.$echarts.init(this.$refs.zzt, 'macarons')
      myzzt.setOption({
        title: {
          text: '职员需求图',
          subtext: '',
          left: 'left'
        },
          tooltip: {
            trigger: 'axis',
            axisPointer: {
              type: 'shadow'
            }
          },
          legend: {
            data: ['预期', '实际', '差值'],
            left: 'center'// 修改图例名称
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
              data: ['技术开发人员', '市场营销人员', '网络安全人员', '会计', '保洁']
            }
          ],
          series: [
            {
              name: '预期', // 修改第一条柱形的名称
              type: 'bar',
              label: {
                show: true,
                position: 'inside'
              },
              emphasis: {
                focus: 'series'
              },
              data: [5, 6, 4, 2, 4]
            },
            {
              name: '实际', // 修改第二条柱形的名称
              type: 'bar',
              stack: 'Total',
              label: {
                show: true
              },
              emphasis: {
                focus: 'series'
              },
              data: [8, 10, 5, 10, 9]
            },
            {
              name: '差值', // 修改第三条柱形的名称
              type: 'bar',
              stack: 'Total',
              label: {
                show: true,
                position: 'left'
              },
              emphasis: {
                focus: 'series'
              },
              data: [-3, -4, -1, -8, -5]
            }
          ]
        }
      );

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
