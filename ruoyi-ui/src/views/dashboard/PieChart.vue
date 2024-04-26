<template>
  <div :class="className" :style="{height:height,width:width}" />
</template>

<script>
import * as echarts from 'echarts'
require('echarts/theme/macarons') // echarts theme
import resize from './mixins/resize'

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
    text: '不同时间段在线人数', // 设置标题文本
    left: 'right', // 标题居中显示
    textStyle: {
      fontSize: 12, // 标题字体大小
      fontWeight: 'bold' // 标题字体粗细
    }
  },
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        legend: {
          left: 'center',
          bottom: '10',
          data: ['00:00 - 05:59', '06:00 - 11:59', '12:00 - 17:59', '18:00 - 21:59', '22:00 - 23:59']
        },
        series: [
          {
            name: '不同时间段在线人数',
            type: 'pie',
            roseType: 'radius',
            radius: [15, 95],
            center: ['50%', '38%'],
            data: [
              { value: 1, name: '00:00 - 05:59' },
              { value: 3, name: '06:00 - 11:59' },
              { value: 7, name: '12:00 - 17:59' },
              { value: 5, name: '18:00 - 21:59' },
              { value: 1, name: '22:00 - 23:59' }
            ],
            animationEasing: 'cubicInOut',
            animationDuration: 2600
          }
        ]
      })
    }
  }
}
</script>
