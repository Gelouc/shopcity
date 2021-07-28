<template>

  <div>
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>登录</span>
        </div>
        <div class="text item" >
        <el-form
          :model="ruleForm" 
          status-icon
          ref="ruleForm"
          label-width="100px"
          class="demo-ruleForm"
        >
          <el-form-item label="用户名">
            <el-input type="text" v-model="ruleForm.userName"></el-input>
          </el-form-item>
          <el-form-item label="密码">
            <el-input
              type="password"
              v-model="ruleForm.userPass"
              autocomplete="off"
            ></el-input>
          </el-form-item>
         
          <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')"
              >提交</el-button
            >
            <el-button @click="resetForm('ruleForm')">重置</el-button>
          </el-form-item>
        </el-form>
        <a href="https://gitee.com/oauth/authorize?client_id=a45d31956c17aff7d5b78db137d2a9096df0cee25e8cdb7112cdc4817a393920&redirect_uri=http://localhost:8081/api/oauth/process&response_type=code">gitee</a>
        
        </div>
      
    </el-card>
  </div>
</template>

<script>
import { mapMutations } from 'vuex';
import {login} from '../service/user'
export default {
  data() {
    return {
      ruleForm: {
       
      },
    };
  },
  methods: {
   
    async submitForm(formName) {
      let response = await login(this.ruleForm.userName,this.ruleForm.userPass);
      if(response.status == 1){
        // console.log(response.data);
        // this.setToken(response.data);
        this.$cookies.set("token",response.data.token);
        this.$cookies.set("refreshToken",response.data.refreshToken);
        this.$router.push("/manage");
      }else{
        alert("登录失败")
      }
      
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    ...mapMutations('user',['setToken'])
  },
};
</script>

<style>
  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }
.box-card {
    margin: auto;
    width: 480px;
  }
</style>