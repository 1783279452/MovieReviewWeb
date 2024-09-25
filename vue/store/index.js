import { createStore } from 'vuex'; // 从 vuex 导入 createStore

export default createStore({
  state: {
    ratingsData: [
      { value: 1048, name: '1星' },
      { value: 735, name: '2星' },
      { value: 580, name: '3星' },
      { value: 484, name: '4星' },
      { value: 300, name: '5星' }
    ],
    genreData: [
      { value: 1048, name: '喜剧' },
      { value: 735, name: '战争' },
      { value: 580, name: '历史' },
      { value: 484, name: '科幻' },
      { value: 300, name: '动作' },
      { value: 200, name: '恐怖' },
      { value: 150, name: '爱情' },
      { value: 120, name: '动画' },
      { value: 90, name: '剧情' }
    ],
    userComparisonData: {
      reviewed: 320,
      notReviewed: 480
    },
    languageData: [
      { value: 600, name: '英语' },
      { value: 400, name: '汉语' }
    ]
  },
  mutations: {
    updateRatingsData(state, newData) {
      state.ratingsData = newData;
    },
    updateGenreData(state, newData) {
      state.genreData = newData;
    },
    updateUserComparisonData(state, newData) {
      state.userComparisonData = newData;
    },
    updateLanguageData(state, newData) {
      state.languageData = newData;
    }
  }
});


