<template>
  <div ref="genreChart" style="width: 100%; height: 400px;"></div>
</template>

<script>
import * as echarts from 'echarts';
import { mapState } from 'vuex';

export default {
  name: "GenreChart",
  computed: {
    ...mapState(['genreData'])
  },
  mounted() {
    this.initChart();
  },
  watch: {
    genreData: 'initChart'
  },
  methods: {
    initChart() {
      const chart = echarts.init(this.$refs.genreChart);
      const option = {
        title: {
          text: '电影类型统计',
          left: 'center',
        },
        tooltip: {
          trigger: 'item',
        },
        series: [
          {
            name: '类型',
            type: 'pie',
            radius: '50%',
            data: this.genreData,
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

