<template>
  <div :class="className" :style="{height:height,width:width}" />
</template>

<script>
import * as echarts from 'echarts'
require('echarts/theme/macarons') // echarts theme
import resize from './mixins/resize'

const animationDuration = 6000

export default {
  mixins: [resize],
  props: {
    className: {
      type: String,
      default: 'chart'
    },
    width: {
      type: String,
      default: '100%'
    },
    height: {
      type: String,
      default: '300px'
    }
  },
  data() {
    return {
      chart: null
    }
  },
  mounted() {
    this.$nextTick(() => {
      this.initChart()
    })
  },
  beforeDestroy() {
    if (!this.chart) {
      return
    }
    this.chart.dispose()
    this.chart = null
  },
  methods: {
    initChart() {
      this.chart = echarts.init(this.$el, 'macarons')

      this.chart.setOption({
        title: {
    text: '不同页面浏览人数', // 设置标题文本
    left: 'right', // 标题居中显示
    textStyle: {
      fontSize: 12, // 标题字体大小
      fontWeight: 'bold' // 标题字体粗细
    }
  },
        tooltip: {
          trigger: 'axis',
          axisPointer: { // 坐标轴指示器，坐标轴触发有效
            type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
          }
        },
        grid: {
          top: 10,
          left: '2%',
          right: '2%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: [{
          type: 'category',
          data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
          axisTick: {
            alignWithLabel: true
          }
        }],
        yAxis: [{
          type: 'value',
          axisTick: {
            show: false
          }
        }],
        series: [{
          name: '数据分析',
          type: 'bar',
          stack: 'vistors',
          barWidth: '60%',
          data: [7, 5, 2, 3, 3, 3, 2],
          animationDuration
        }, {
          name: '首页',
          type: 'bar',
          stack: 'vistors',
          barWidth: '60%',
          data: [10, 5, 8, 7, 5, 8, 11],
          animationDuration
        }, {
          name: '应聘成员',
          type: 'bar',
          stack: 'vistors',
          barWidth: '60%',
          data: [6, 2, 2, 4, 1, 5, 2],
          animationDuration
        }]
      })
    }
  }
}
</script>
