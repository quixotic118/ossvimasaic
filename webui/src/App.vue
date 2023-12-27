<script setup lang="ts">
import {RouterLink, RouterView} from 'vue-router'
import HelloWorld from './components/HelloWorld.vue'
import {onMounted} from "vue"
import {PageSideWidth} from "@/config/constants"
import PageSide from "@/components/PageSide.vue"

onMounted(() => {
  const appNode: HTMLElement | null = document.querySelector('#app')
  if (appNode != null) {
    appNode.style.height = window.innerHeight + 'px'
  }
  document.body.setAttribute('arco-theme', 'dark')
})
</script>

<template>
  <a-layout id="PageContainer">
    <a-layout-sider :width="PageSideWidth" id="PageSide">
      <PageSide />
    </a-layout-sider>
    <a-layout-content>
      <RouterView/>
    </a-layout-content>
  </a-layout>
</template>

<style scoped>
#PageContainer {
  width: 100%;
  height: 100%;
  padding: 0;
  margin: 0;
  user-select: none;
}

#PageSide {
  height: 100%;
}
</style>
