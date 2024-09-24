import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import ElementPlus from 'element-plus'
import zhCn from 'element-plus/dist/locale/zh-cn.mjs'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

import '@/assets/css/global.css'
import { createApp } from 'vue'
import App from './App.vue'

// 引入 echarts
import * as echarts from 'echarts'
const app = createApp(App)
// 全局挂载 echarts
app.config.globalProperties.$echarts = echarts

app.mount('#app')
const app = createApp(App)

app.use(router)
app.use(ElementPlus, {
    locale: zhCn,
})
app.mount('#app')

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}