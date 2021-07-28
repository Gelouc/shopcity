<template>
  <el-container>
    <el-header height="80px">
        <el-row class="header">
            <el-col :span="4"><h1>XXX管理系统:</h1></el-col>
            <el-col :span="4" :offset="15"><h3>用户名：{{user.userName}}</h3></el-col>
            <el-col :span="1" ><el-button type="primary" icon="el-icon-upload2" circle @click="handleLogout" ></el-button></el-col>
        </el-row>
        
    </el-header>
    <el-container>
        <el-aside width="200px">
            <el-menu
      :default-active="$router.history.current.path"
      class="el-menu-vertical-demo"

      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
      :router="true">
      <template>

      </template>
      <!-- <el-menu-item v-for="ele in functions" :key="ele.functionId" :index="ele.url">
        <i class="el-icon-menu"></i>
        <span slot="title">{{ele.functionName}}</span>
      </el-menu-item> -->
      <el-menu-item index="/manage/user">
        <i class="el-icon-menu"></i>
        <span slot="title">用户管理</span>
      </el-menu-item>
      <el-menu-item index="/manage/student">
        <i class="el-icon-menu"></i>
        <span slot="title">角色管理</span>
      </el-menu-item>
      <el-menu-item index="/manage/student">
        <i class="el-icon-menu"></i>
        <span slot="title">权限管理</span>
      </el-menu-item>
      
      
    </el-menu>
        </el-aside>
        <el-main>
            <router-view></router-view>
        </el-main>
    </el-container>
</el-container>
</template>

<script>
import { mapState } from 'vuex';
import {getUser,logout,refreshToken} from '../service/user'
export default {
  async created(){
    // console.log('token',this.token);
    // 获取路径后面的token信息，如果没有则从cookie里面获取
    let token = this.$router.history.current.query.token;
    
    // console.log("access_token",this.$router.history.current.query.token);
    
    if(!token){
      token = this.$cookies.get('token')
    }else{
      this.$cookies.set('token',token)
    }
    
    let response = await getUser(token);
    console.log('toke',response.data)
    if(response.status == 2009){
      // 刷新token后将新的token保存到cookie中
      console.log("refreshToken",this.$cookies.get('refreshToken'));
      let newTokenResponse = await refreshToken(this.$cookies.get('refreshToken'));
      this.$cookies.set("token",newTokenResponse.data);
      response = await getUser(newTokenResponse.data);
    }
    if(response.status != 1){
      this.$router.push("/login");
    }else{
      this.user = response.data;
    }
  },
    data(){
      return {
        user:{}
      }
    },
    computed:{
      ...mapState('user',['token'])
    },
    methods:{
      async handleLogout(){
        // await logout();
        this.$cookies.remove('token');
        this.$router.push("/login");
      }
    },
   
}
</script>

<style>
    .el-header{
        background: #2b303b;
        color: white;
        
    }
    .header{
        display: flex;
        align-items: center;
    }
    .el-container,.el-aside,.el-menu{
        height:100%;
    }
</style>