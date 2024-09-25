<template>
  <div ref="ratingChart" style="width: 100%; height: 400px;"></div>
</template>

<script>
import * as echarts from 'echarts';
import { mapState } from 'vuex';

export default {
  name: "RatingChart",
  computed: {
    ...mapState(['ratingsData'])
  },
  mounted() {
    this.initChart();
  },
  watch: {
    ratingsData: 'initChart' // 当 ratingsData 变化时重新渲染图表
  },
  methods: {
    initChart() {
      const chart = echarts.init(this.$refs.ratingChart);
      const option = {
        title: {
          text: '电影影评评分占比',
          left: 'center',
        },
        tooltip: {
          trigger: 'item',
        },
        series: [
          {
            name: '评分',
            type: 'pie',
            radius: '50%',
            data: this.ratingsData,
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)',
              },
            },
          },
        ],
      };
      chart.setOption(option);
    },
  },
};
</script>
