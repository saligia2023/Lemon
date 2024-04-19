<template>
  <div class="password-reset">
    <el-form ref="resetForm" :model="resetForm" :rules="resetRules" class="reset-form">
      <h3 class="title">密码重置</h3>
      <el-form-item prop="email">
        <el-input v-model="resetForm.email" type="email" auto-complete="off" placeholder="注册邮箱">
          <svg-icon slot="prefix" icon-class="email" class="el-input__icon input-icon" />
        </el-input>
      </el-form-item>
      <el-form-item prop="code" v-if="captchaEnabled">
        <el-input
          v-model="resetForm.code"
          auto-complete="off"
          placeholder="验证码"
          style="width: 63%"
          @keyup.enter.native="handleSubmit"
        >
          <svg-icon slot="prefix" icon-class="validCode" class="el-input__icon input-icon" />
        </el-input>
        <div class="reset-code">
          <img :src="codeUrl" @click="getCode" class="reset-code-img" />
        </div>
      </el-form-item>
      <el-form-item style="width:100%;">
        <el-button
          :loading="loading"
          size="medium"
          type="primary"
          style="width:100%;"
          @click.native.prevent="handleSubmit"
        >
          <span v-if="!loading">提交</span>
          <span v-else>提交中...</span>
        </el-button>
        <div style="float: right;">
          <router-link class="link-type" :to="'/login'">返回登录</router-link>
        </div>
      </el-form-item>
    </el-form>
    <!--  底部  -->
    <div class="el-reset-footer">
      <span>Copyright © 2018-2024 ruoyi.vip All Rights Reserved.</span>
    </div>
  </div>
</template>

<script>
import { getCodeImg, forget_password } from "@/api/login";

export default {
  name: "forget_password",
  data() {
    return {
      codeUrl: "",
      resetForm: {
        email: "",
        code: "",
        uuid: ""
      },
      resetRules: {
        email: [
          { required: true, type: 'email', message: "请输入正确的邮箱地址", trigger: "blur" }
        ],
        code: [{ required: true, trigger: "change", message: "请输入验证码" }]
      },
      loading: false,
      captchaEnabled: true
    };
  },
  created() {
    this.getCode();
  },
  methods: {
    getCode() {
      getCodeImg().then(res => {
        this.captchaEnabled = res.captchaEnabled === undefined ? true : res.captchaEnabled;
        if (this.captchaEnabled) {
          this.codeUrl = "data:image/gif;base64," + res.img;
          this.resetForm.uuid = res.uuid;
        }
      });
    },
    handleSubmit() {
      this.$refs.resetForm.validate(valid => {
        if (valid) {
          this.loading = true;
          //forget_password().then(res => {
            this.$alert("请检查您的邮箱,重置密码已发送。", '系统提示', {
              type: 'success'
            }).then(() => {
              this.$router.push("/login");
            //}).catch(() => {});
          }).catch(() => {
            this.loading = false;
            if (this.captchaEnabled) {
              this.getCode();
            }
          })
        }
      });
    }
  }
};
</script>

<style rel="stylesheet/scss" lang="scss">
.password-reset {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  background-image: url("../assets/images/login-background.jpg");
  background-size: cover;
}
.title {
  margin: 0px auto 30px auto;
  text-align: center;
  color: #707070;
}

.reset-form {
  border-radius: 6px;
  background: #ffffff;
  width: 400px;
  padding: 25px 25px 5px 25px;
  .el-input {
    height: 38px;
    input {
      height: 38px;
    }
  }
  .input-icon {
    height: 39px;
    width: 14px;
    margin-left: 2px;
  }
}
.reset-code {
  width: 33%;
  height: 38px;
  float: right;
  img {
    cursor: pointer;
    vertical-align: middle;
  }
}
.el-reset-footer {
  height: 40px;
  line-height: 40px;
  position: fixed;
  bottom: 0;
  width: 100%;
  text-align: center;
  color: #fff;
  font-family: Arial;
  font-size: 12px;
  letter-spacing: 1px;
}
.reset-code-img {
  height: 38px;
}
</style>
