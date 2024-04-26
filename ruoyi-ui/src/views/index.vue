<template>
  <div>
    <div v-if="checkRole(['admin','HR'])">
      <div class="dashboard-editor-container" >
        <!-- 用户信息显示区域 -->
        <el-row class="user-info" align="middle" justify="end" style="margin-bottom: 20px;">
          <el-col style="flex: auto;margin-right: 20%">
            <img src="../assets/images/profile.jpg" class="user-avatar">
          </el-col>
          <el-col style="flex: auto">
            <div class="user-details">
              <span class="user-name ">{{ user.userName  }}</span>
              <span class="access">{{ roleGroup }}</span>
              <span class="user-login-address ">登陆地点：扬州</span>
              <span class="login-time ">登录时间：{{ loginTime }}</span>
            </div>
          </el-col>
        </el-row>

        <panel-group @handleSetLineChartData="handleSetLineChartData" />

        <el-row style="background:#fff;padding:16px 16px 0;margin-bottom:32px;">
          <line-chart :chart-data="lineChartData" />
        </el-row>

        <el-row :gutter="32">
          <el-col :xs="24" :sm="24" :lg="8">
            <div class="chart-wrapper">
              <raddar-chart />
            </div>
          </el-col>
          <el-col :xs="24" :sm="24" :lg="8">
            <div class="chart-wrapper">
              <pie-chart />
            </div>
          </el-col>
          <el-col :xs="24" :sm="24" :lg="8">
            <div class="chart-wrapper">
              <bar-chart />
            </div>
          </el-col>
        </el-row>
      </div>
    </div>

    <div v-else-if="checkRole(['user'])">
      <div>
        <el-card :span="20" style="display: flex; justify-content: center;height: 900px;margin-top: 10px">
          <el-row :gutter="16">
            <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="80px">
              <el-row style="flex: auto;">
                <el-col :span="7">
                  <el-form-item label="姓名" prop="field105">
                    <el-input v-model="formData.field105" placeholder="请输入姓名" clearable :style="{width: '100%'}">
                    </el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="5">
                  <el-form-item label="性别" prop="field106">
                    <el-select v-model="formData.field106" clearable :style="{width: '100%'}">
                      <el-option v-for="(item, index) in field106Options" :key="index" :label="item.label"
                                 :value="item.value" :disabled="item.disabled"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="出生日期" prop="field107">
                    <el-date-picker v-model="formData.field107" format="yyyy-MM-dd" value-format="yyyy-MM-dd"
                                    :style="{width: '100%'}" placeholder="请选择出生日期" clearable></el-date-picker>
                  </el-form-item>
                </el-col>
              </el-row>

              <el-row style="flex: auto;">
                <el-col :span="8">
                  <el-form-item label="籍贯" prop="field104">
                    <el-input v-model="formData.field104" placeholder="请输入籍贯" clearable :style="{width: '100%'}">
                    </el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="手机号" prop="mobile">
                    <el-input v-model="formData.mobile" placeholder="请输入手机号" :maxlength="11" show-word-limit clearable
                              prefix-icon='el-icon-mobile' :style="{width: '100%'}"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>


              <el-row style="flex: auto;">
                <el-col :span="12">
                  <el-form-item label="邮箱" prop="field119">
                    <el-input v-model="formData.field119" placeholder="输入请邮箱" clearable :style="{width: '100%'}">
                    </el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="学历" prop="field110">
                    <el-select v-model="formData.field110" placeholder="请选择" clearable :style="{width: '100%'}">
                      <el-option v-for="(item, index) in field110Options" :key="index" :label="item.label"
                                 :value="item.value" :disabled="item.disabled"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>


              <el-row style="flex: auto;">
                <el-col :span="10">
                  <el-form-item label="应聘岗位" prop="field108">
                    <el-select v-model="formData.field108" placeholder="请选择应聘岗位" clearable :style="{width: '100%'}">
                      <el-option v-for="(item, index) in field108Options" :key="index" :label="item.label"
                                 :value="item.value" :disabled="item.disabled"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="10">
                  <el-form-item label="工作经验" prop="field114">
                    <el-select v-model="formData.field114" placeholder="请选择工作经验" clearable :style="{width: '100%'}">
                      <el-option v-for="(item, index) in field114Options" :key="index" :label="item.label"
                                 :value="item.value" :disabled="item.disabled"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>

              <el-row style="flex: auto;">
                <el-col :span="10">
                  <el-form-item label="期望薪资" prop="field115">
                    <el-select v-model="formData.field115" placeholder="请选择期望薪资" clearable :style="{width: '100%'}">
                      <el-option v-for="(item, index) in field115Options" :key="index" :label="item.label"
                                 :value="item.value" :disabled="item.disabled"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="10">
                  <el-form-item label="投递渠道" prop="field130">
                    <el-select v-model="formData.field130" placeholder="请选择投递渠道" clearable :style="{width: '100%'}">
                      <el-option v-for="(item, index) in field130Options" :key="index" :label="item.label"
                                 :value="item.value" :disabled="item.disabled"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>

              <el-row style="flex: auto;">
                <el-col :span="20">
                  <el-form-item label="工作经历" prop="field116">
                    <el-input v-model="formData.field116" type="textarea" placeholder="请输入工作经历"
                              :autosize="{minRows: 2, maxRows: 5}" :style="{width: '100%'}"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>

              <el-row style="flex: auto;">
                <el-col :span="20">
                  <el-form-item label="自我评价" prop="field120">
                    <el-input v-model="formData.field120" type="textarea" placeholder="请输入自我评价"
                              :autosize="{minRows: 4, maxRows: 4}" :style="{width: '100%'}"></el-input>
                  </el-form-item>
                </el-col>

              </el-row>

              <el-row style="flex: auto;">
                <el-col :span="4">
                  <el-form-item label="上传简历" prop="field118" required>
                    <el-upload ref="field118" :file-list="field118fileList" :action="field118Action"
                               :before-upload="field118BeforeUpload">
                      <el-button size="small" type="primary" icon="el-icon-upload">点击上传</el-button>
                    </el-upload>
                  </el-form-item>
                </el-col>
              </el-row>

              <el-row style="flex: auto;">
                <el-col :span="20">
                  <el-form-item size="large">
                    <form @submit.prevent="handleSubmit">
                      <el-button type="primary" @click="submitForm">提交</el-button>
                      <el-button @click="resetForm">重置</el-button>
                    </form>


                    <modal v-if="showModal" @close="closeModal">
                      <p>提交成功！</p>
                      <button @click="closeModal">关闭</button>
                    </modal>

                  </el-form-item>
                </el-col>
              </el-row>
            </el-form>
          </el-row>
        </el-card>
      </div>
    </div>
  </div>

</template>


<script>
import { checkPermi, checkRole } from "@/utils/permission"; // 权限判断函数
import PanelGroup from './dashboard/PanelGroup'
import LineChart from './dashboard/LineChart'
import RaddarChart from './dashboard/RaddarChart'
import PieChart from './dashboard/PieChart'
import BarChart from './dashboard/BarChart'
import { getUserProfile } from "@/api/system/user";


const lineChartData = {
  newVisitis: {
    expectedData: [10, 12, 16, 13, 10, 16, 16],
    actualData: [12, 8, 9, 15, 16, 14, 14]
  },
  messages: {
    expectedData: [20, 19, 12, 14, 16, 13, 14],
    actualData: [18, 16, 15, 16, 14, 15, 13]
  },
  purchases: {
    expectedData: [8, 10, 12, 10, 10, 9, 10],
    actualData: [12, 9, 10, 13, 14, 13, 13]
  },
  shoppings: {
    expectedData: [13, 14, 11, 14, 14, 15, 16],
    actualData: [12, 8, 9, 15, 16, 14, 13]
  }
}
export default {
  name: 'Index',
  components: {
    PanelGroup,
    LineChart,
    RaddarChart,
    PieChart,
    BarChart
  },
  mounted() {
    this.getUser();
  },
  props: [],
  data() {
    return {
      user: {},
      roleGroup: {},
      lineChartData: lineChartData.newVisitis,
      userInfo: {
        name: 'John Doe',
        avatar: 'path/to/avatar.jpg',
        loginAddress: 'New York, NY'
      },
      loginTime: new Date().toLocaleString(),
      formData: {
        field105: undefined,
        field106: 1,
        field118: null,
        field107: null,
        field104: undefined,
        mobile: '',
        field119: undefined,
        field110: '',
        field108: '',
        field114: undefined,
        field115: undefined,
        field116: '',
        field117: undefined,
        field120: undefined,
        field130: undefined
      },
      rules: {
        field130: [{
          required: true,
          message: '请选择投递渠道',
          trigger: 'change'
        }],
        field105: [{
          required: true,
          message: '请输入姓名',
          trigger: 'blur'
        }],
        field106: [{
          required: true,
          message: '',
          trigger: 'change'
        }],
        field107: [{
          required: true,
          message: '请选择出生日期',
          trigger: 'change'
        }],
        field104: [{
          required: true,
          message: '请输入籍贯',
          trigger: 'blur'
        }],
        mobile: [{
          required: true,
          message: '请输入手机号',
          trigger: 'blur'
        }, {
          pattern: /^1(3|4|5|7|8|9)\d{9}$/,
          message: '手机号格式错误',
          trigger: 'blur'
        }],
        field119: [{
          required: true,
          message: '输入请邮箱',
          trigger: 'blur'
        }],
        field110: [{
          required: true,
          message: '请选择',
          trigger: 'change'
        }],
        field108: [{
          required: true,
          message: '请选择应聘岗位',
          trigger: 'change'
        }],
        field114: [{
          required: true,
          message: '请选择工作经验',
          trigger: 'change'
        }],
        field115: [{
          required: true,
          message: '请选择期望薪资',
          trigger: 'change'
        }],
        field116: [{
          required: true,
          message: '请输入工作经历',
          trigger: 'blur'
        }],
        field117: [{
          required: true,
          message: '请输入获得荣耀',
          trigger: 'blur'
        }],
        field120: [{
          required: true,
          message: '请输入自我评价',
          trigger: 'blur'
        }],
      },
      field118Action: 'https://jsonplaceholder.typicode.com/posts/',
      field118fileList: [],
      field106Options: [{
        "label": "男",
        "value": 1
      }, {
        "label": "女",
        "value": 2
      }],
      field110Options: [{
        "label": "初中毕业",
        "value": 1
      }, {
        "label": "技校毕业",
        "value": 2
      }, {
        "label": "高中毕业",
        "value": 3
      },{
        "label": "大专毕业",
        "value": 4
      }, {
        "label": "本科学士",
        "value": 5
      }, {
        "label": "硕士研究生",
        "value": 6
      }, {
        "label": "博士研究生",
        "value":7
      }],
      field108Options: [{
        "label": "java工程师",
        "value": 1
      }, {
        "label": "数据分析师",
        "value": 2
      }, {
        "label": "销售经理",
        "value": 3
      }, {
        "label": "项目经理",
        "value": 4
      }, {
        "label": "UI设计师",
        "value": 5
      },
        {"label": "网路安全工程师",
          "value": 6
        },
        {
          "label": "数据库管理员",
          "value": 7
        },
        {
          "label": "财务经理",
          "value": 8
        },
        {
          "label": "技术支持工程师",
          "value": 9
        },
        {
          "label": "市场分析师",
          "value": 10
        },
        {
          "label": "研发工程师",
          "value": 11
        },
        {
          "label": "公关专员",
          "value": 12
        },
        {
          "label": "客服代表",
          "value": 13
        }
        ,
        {
          "label": "客服服务",
          "value": 14
        },
        {
          "label": "人力资源经理",
          "value": 15
        }

      ],
      field114Options: [{
        "label": "无",
        "value": 1
      }, {
        "label": "2年以内",
        "value": 2
      }, {
        "label": "2-4年",
        "value": 3
      }, {
        "label": "4-6年",
        "value": 4
      }, {
        "label": "6-8年",
        "value": 5
      }, {
        "label": "8-10年",
        "value": 6
      }, {
        "label": "10年以上",
        "value": 7
      }],
      field130Options: [{
        "label": "Boss直聘",
        "value": 1
      }, {
        "label": "58同城",
        "value": 2
      }, {
        "label": "内部推荐",
        "value": 3
      }, {
        "label": "赶集直招",
        "value": 4
      }, {
        "label": "校园招聘",
        "value": 5
      }],
      field115Options: [{
        "label": "3k-6k",
        "value": 1
      }, {
        "label": "6k-9k",
        "value": 2
      }, {
        "label": "9k-12k",
        "value": 3
      }, {
        "label": "12k以上",
        "value": 4
      }],
    }
  },
  computed: {},
  watch: {},
  created() {},
  methods: {
    getUser() {
      getUserProfile().then(response => {
        this.user = response.data;
        this.roleGroup = response.roleGroup;
        this.lastUpdatedTime = this.formatDate(new Date());  // 更新时间
      });
    },
    handleSetLineChartData(type) {
      this.lineChartData = lineChartData[type]
    },
    checkPermi,
    checkRole,
    submitForm() {
      this.$refs['elForm'].validate(valid => {
        if (!valid) return
        // TODO 提交表单
      })
    },
    resetForm() {
      this.$refs['elForm'].resetFields()
    },
    field118BeforeUpload(file) {
      let isRightSize = file.size / 1024 / 1024 < 2
      if (!isRightSize) {
        this.$message.error('文件大小超过 2MB')
      }
      return isRightSize
    },
  }
}

</script>

<style lang="scss" scoped>
.el-upload__tip {
  line-height: 1.2;
}
.dashboard-editor-container {
  padding: 32px;
  background-color: rgb(240, 242, 245);
  position: relative;

  .chart-wrapper {
    background: #fff;
    padding: 16px 16px 0;
    margin-bottom: 32px;
  }

  .user-info {
    border: 1px solid #ccc;
    padding: 0; // 设置为0，去除内边距
    border-radius: 8px;
    background: #fff;
    box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
    font-size: 14px;
    color: #333;
    display: flex; // 使容器内的元素水平布局
    align-items: center; // 垂直居中对齐

    .user-avatar {
      border: 2px solid #f0f0f0;
      width: 100px; // 维持此大小
      height: 100px; // 维持此大小
      border-radius: 50%;
      margin: 0; // 确保头像不会有额外边距
    }
    .user-details {
      display: flex;
      align-items: center;
      justify-content: flex-end;

      .user-name, .access { // 使用.access类为roleGroup添加样式
        font-weight: bold; // 加粗字体
        font-size: 18px; // 增加字体大小，您可以根据需求调整大小
        margin-right: 16px; // 维持原有的右边距
        padding-left: 10px; // 新增左边距
        padding-right: 10px; // 新增右边距
      }

      .user-login-address {
        font-weight: bold;
        margin-right: 16px; // 维持原有的右边距
        padding-left: 10px; // 新增左边距
        padding-right: 10px; // 新增右边距
      }

      .login-time {
        font-weight: bold;
        padding-left: 10px; // 新增左边距
        padding-right: 10px; // 新增右边距
      }
    }



  }
}

@media (max-width: 1024px) {
  .chart-wrapper {
    padding: 8px;
  }
}
</style>

