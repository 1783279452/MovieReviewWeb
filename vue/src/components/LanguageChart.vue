<template>
  <div ref="languageChart" style="width: 100%; height: 400px;"></div>
</template>

<script>
import * as echarts from 'echarts';
import { mapState } from 'vuex';

export default {
  name: "LanguageChart",
  computed: {
    ...mapState(['languageData'])
  },
  mounted() {
    this.initChart();
  },
  watch: {
    languageData: 'initChart'
  },
  methods: {
    initChart() {
      const chart = echarts.init(this.$refs.languageChart);
      const option = {
        title: {
          text: '电影发布语言占比',
          left: 'center',
        },
        tooltip: {
          trigger: 'item',
        },
        series: [
          {
            name: '语言',
            type: 'pie',
            radius: '50%',
            data: this.languageData,
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

