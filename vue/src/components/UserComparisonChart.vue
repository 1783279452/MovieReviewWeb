<template>
  <div ref="userComparisonChart" style="width: 100%; height: 400px;"></div>
</template>

<script>
import * as echarts from 'echarts';
import { ref, computed, onMounted, watch, nextTick } from 'vue';  // 导入 nextTick
import { useStore } from 'vuex';

export default {
  name: "UserComparisonChart",
  setup() {
    const store = useStore();
    const userComparisonChart = ref(null); // 引用 DOM 元素

    // 使用 computed 访问 Vuex 状态
    const reviewed = computed(() => store.state.userComparisonData.reviewed);
    const notReviewed = computed(() => store.state.userComparisonData.notReviewed);

    // 初始化图表
    const initChart = () => {
      if (userComparisonChart.value) {  // 检查 DOM 是否已绑定
        const chart = echarts.init(userComparisonChart.value); // 使用 ref 的值

        const option = {
          title: {
            text: '评论用户 vs 未评论用户',
            left: 'center',
          },
          tooltip: {
            trigger: 'axis',
          },
          xAxis: {
            type: 'category',
            data: ['用户'],
          },
          yAxis: {
            type: 'value',
          },
          series: [
            {
              name: '评论用户数',
              type: 'bar',
              data: [reviewed.value],
              color: '#3398DB',
            },
            {
              name: '未评论用户数',
              type: 'bar',
              data: [notReviewed.value],
              color: '#d14a61',
            },
          ],
        };
        chart.setOption(option);
      }
    };

    // 监听数据变化并重新渲染图表
    watch([reviewed, notReviewed], initChart);

    // 组件挂载时初始化图表
    onMounted(() => {
      nextTick(() => {
        initChart(); // 确保在 DOM 渲染完成后初始化
      });
    });

    return {
      userComparisonChart,
    };
  }
};
</script>

<style scoped>
/* 可根据需要调整样式 */
</style>

