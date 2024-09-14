<template>
  <div>

       <div style="width: 50%">
         <div style="margin-bottom:20px;padding-left: 50px;font-size: 20px;font-weight: bold">系统公告</div>
         <el-timeline>
           <el-timeline-item v-for="item in data.noticeList" :key="item.id" :timestamp="item.time" placement="top">
             <div class="card">
               <div style="font-weight: bold;margin-bottom: 10px;font-size: 16px">{{item.title}}</div>
               <div style="color: #666">{{item.content}}</div>
             </div>
           </el-timeline-item>
         </el-timeline>
       </div>

  </div>
</template>

<script setup>
import { reactive } from "vue";
import request from "@/utils/request";

const data = reactive({
  user: JSON.parse(localStorage.getItem('system-user') || '{}'),
  noticeList:[]
})

request.get('/notice/selectAll').then(res=>{
  data.noticeList = res.data
})
</script>