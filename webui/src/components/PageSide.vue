<script setup lang="ts">

import IconSupport from "@/components/icons/IconSupport.vue"
import {ref} from "vue"

const themeName = ref<string>('夜间')

</script>

<template>
  <div class="side-container">
    <div class="top-side">
      <a-row>Top</a-row>
    </div>
    <div class="btm-side">
      <div class="item">
        <div class="item-icon"><IconSupport /></div>
        <div>{{themeName}}</div>
      </div>
      <div class="item">Btm</div>
    </div>
  </div>
</template>

<style scoped>
.side-container{
  margin: 0;
  padding: 0;
  width: 100%;
  height: 100%;
  font-size: 16px;
  overflow: hidden;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
}

.item{
  margin: 10px auto;
  height: 50px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
}

.item:hover{
  cursor: pointer;
}

.item-icon{
  margin-bottom: 5px;
}
</style>
