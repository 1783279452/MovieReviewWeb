import { createApp } from 'vue'
import App from './App.vue'
import ECharts from 'vue-echarts';
import router from './router'
import ElementPlus from 'element-plus'
import zhCn from 'element-plus/dist/locale/zh-cn.mjs'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import 'echarts';
import '@/assets/css/global.css'

const app = createApp(App)

app.use(router)
app.use(ElementPlus, {
    locale: zhCn,
})
app.component('ECharts', ECharts)
app.mount('#app')

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}