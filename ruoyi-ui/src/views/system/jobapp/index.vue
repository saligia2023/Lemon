<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="姓名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别" prop="gender">
        <el-select v-model="queryParams.gender" placeholder="请选择性别" clearable>
          <el-option
            v-for="dict in dict.type.sys_user_sex"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="年龄" prop="age">
        <el-input
          v-model="queryParams.age"
          placeholder="请输入年龄"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="电话" prop="phone">
        <el-input
          v-model="queryParams.phone"
          placeholder="请输入电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学历" prop="education">
        <el-select v-model="queryParams.education" placeholder="请选择学历" clearable>
          <el-option
            v-for="dict in dict.type.sys_education"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="期望工资" prop="expectedSalary">
        <el-select v-model="queryParams.expectedSalary" placeholder="请选择期望工资" clearable>
          <el-option
            v-for="dict in dict.type.sys_money"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="应聘职位" prop="positionApplied">
        <el-select v-model="queryParams.positionApplied" placeholder="请选择应聘职位" clearable>
          <el-option
            v-for="dict in dict.type.sys_job_want"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="求职状态" prop="jobStatus">
        <el-select v-model="queryParams.jobStatus" placeholder="请选择求职状态" clearable>
          <el-option
            v-for="dict in dict.type.sys_job_applicants"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="匹配度" prop="matchPercentage">
        <el-input
          v-model="queryParams.matchPercentage"
          placeholder="请输入匹配度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="风险评估" prop="riskAssessment">
        <el-select v-model="queryParams.riskAssessment" placeholder="请选择风险评估" clearable>
          <el-option
            v-for="dict in dict.type.sys_risk"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:jobapp:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:jobapp:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:jobapp:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:jobapp:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
      
      <el-col :span="1.5">
      <el-button
        type="info"
        plain
        size="mini"
        @click="handleBackgroundCheck1"

      >背景调查1</el-button>
    </el-col>
    <el-col :span="1.5">
      <el-button
        type="info"
        plain
        size="mini"
        @click="handleBackgroundCheck2"

      >背景调查2</el-button>
    </el-col>
    <el-col :span="1.5">
      <el-button
        type="info"
        plain
        size="mini"
        @click="handleBackgroundCheck3"

      >背景调查3</el-button>
    </el-col>
    </el-row>

    <el-table v-loading="loading" :data="jobappList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />

      <el-table-column label="姓名" align="center" prop="name" />
      <el-table-column label="性别" align="center" prop="gender">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_user_sex" :value="scope.row.gender"/>
        </template>
      </el-table-column>
      <el-table-column label="年龄" align="center" prop="age" />
      <el-table-column label="电话" align="center" prop="phone" />
      <el-table-column label="学历" align="center" prop="education">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_education" :value="scope.row.education"/>
        </template>
      </el-table-column>
      <el-table-column label="期望工资" align="center" prop="expectedSalary">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_money" :value="scope.row.expectedSalary"/>
        </template>
      </el-table-column>
      <el-table-column label="应聘职位" align="center" prop="positionApplied">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_job_want" :value="scope.row.positionApplied"/>
        </template>
      </el-table-column>
      <el-table-column label="求职状态" align="center" prop="jobStatus">
  <template slot-scope="scope">
    <!-- 显示标签，非编辑状态 -->
    <div v-if="editingRow !== scope.row.userId">
      <dict-tag :options="dict.type.sys_job_applicants" :value="scope.row.jobStatus" @click.native="editJobStatus(scope.row)"/>
    </div>
    <!-- 编辑状态，显示下拉选择 -->
    <el-select v-else v-model="scope.row.jobStatus" placeholder="请选择求职状态"
               @change="updateJobStatus(scope.row, $event)"
               >
      <el-option
        v-for="dict in dict.type.sys_job_applicants"
        :key="dict.value"
        :label="dict.label"
        :value="dict.value">
      </el-option>
    </el-select>
  </template>
</el-table-column>
      <el-table-column label="工作经验" align="center" prop="workExperience" />
      <el-table-column label="匹配度" align="center" prop="matchPercentage" />
      <el-table-column label="风险评估" align="center" prop="riskAssessment">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_risk" :value="scope.row.riskAssessment"/>
        </template>
      </el-table-column>
      <el-table-column label="风险概要" align="center" prop="riskSummaryUrl">
  <template slot-scope="scope">
    <!-- 只有当 riskSummaryUrl 存在且不为空时，才显示链接 -->
    <a v-if="scope.row.riskSummaryUrl" :href="getFullURL(scope.row.riskSummaryUrl)" target="_blank" title="点击查看概要">
      查看风险概要
    </a>
    <!-- 可选：如果没有附件，显示提示信息 -->
    <span v-else>未上传</span>
  </template>
</el-table-column>
      
      <el-table-column label="简历" align="center" prop="resumeUrl">
  <template slot-scope="scope">
    <!-- 只有当 resumeUrl 存在且不为空时，才显示链接 -->
    <a v-if="scope.row.resumeUrl" :href="getFullURL(scope.row.resumeUrl)" target="_blank" title="点击查看简历">
      查看简历
    </a>
    <!-- 可选：如果没有附件，显示提示信息 -->
    <span v-else>未上传</span>
  </template>
</el-table-column>
      
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:jobapp:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:jobapp:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改招聘信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="性别" prop="gender">
          <el-select v-model="form.gender" placeholder="请选择性别">
            <el-option
              v-for="dict in dict.type.sys_user_sex"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="年龄" prop="age">
          <el-input v-model="form.age" placeholder="请输入年龄" />
        </el-form-item>
        <el-form-item label="电话" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入电话" />
        </el-form-item>
        <el-form-item label="学历" prop="education">
          <el-select v-model="form.education" placeholder="请选择学历">
            <el-option
              v-for="dict in dict.type.sys_education"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="期望工资" prop="expectedSalary">
          <el-select v-model="form.expectedSalary" placeholder="请选择期望工资">
            <el-option
              v-for="dict in dict.type.sys_money"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="应聘职位" prop="positionApplied">
          <el-select v-model="form.positionApplied" placeholder="请选择应聘职位">
            <el-option
              v-for="dict in dict.type.sys_job_want"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="求职状态" prop="jobStatus">
          <el-select v-model="form.jobStatus" placeholder="请选择求职状态">
            <el-option
              v-for="dict in dict.type.sys_job_applicants"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="工作经验" prop="workExperience">
          <el-input v-model="form.workExperience" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="匹配度" prop="matchPercentage">
          <el-input v-model="form.matchPercentage" placeholder="请输入匹配度" />
        </el-form-item>
        <el-form-item label="风险评估" prop="riskAssessment">
          <el-select v-model="form.riskAssessment" placeholder="请选择风险评估">
            <el-option
              v-for="dict in dict.type.sys_risk"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="风险概要" prop="riskSummaryUrl">
          <file-upload v-model="form.riskSummaryUrl"/>
        </el-form-item>
        <el-form-item label="简历" prop="resumeUrl">
          <file-upload v-model="form.resumeUrl"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listJobapp, getJobapp, delJobapp, addJobapp, updateJobapp } from "@/api/system/jobapp";

export default {
  name: "Jobapp",
  dicts: ['sys_job_want', 'sys_education', 'sys_risk', 'sys_money', 'sys_user_sex', 'sys_job_applicants'],
  data() {
    return {
      editingRow: null,
      baseURL: 'http://10.135.138.17:80/dev-api',
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 招聘信息表格数据
      jobappList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        gender: null,
        age: null,
        phone: null,
        education: null,
        expectedSalary: null,
        positionApplied: null,
        jobStatus: null,
        workExperience: null,
        matchPercentage: null,
        riskAssessment: null,
        riskSummaryUrl: null,
        resumeUrl: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        name: [
          { required: true, message: "姓名不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    handleBackgroundCheck1() {
      window.open('https://www.yinuobeidiao.com/');
    },
    handleBackgroundCheck2() {
      window.open ('https://www.ibeidiao.com/');
    }, 
    handleBackgroundCheck3() {
      window.open ('https://www.zmbeidiao.com/');
    },
    editJobStatus(row) {
      this.editingRow = row.userId; // 否则设置为编辑状态
    },
    updateJobStatus(row, newValue) {
  const oldStatus = row.jobStatus;
  const index = this.jobappList.findIndex(item => item.userId === row.userId);
  if (index !== -1) {
    updateJobapp({...row, jobStatus: newValue}).then(response => {
      // 使用Vue.set来确保视图可以响应状态的更新
      this.$set(this.jobappList[index], 'jobStatus', newValue);
      this.$modal.msgSuccess("状态更新成功");
      this.editingRow = null; // 重置正在编辑的行
    }).catch(error => {
      this.$set(this.jobappList[index], 'jobStatus', oldStatus); // 出错时回滚到旧状态
      this.$modal.msgError("状态更新失败");
      console.error("更新失败:", error);
      this.editingRow = null; // 重置正在编辑的行
    });
  }
},
    getFullURL(relativePath) {
    const parts = relativePath.split('/'); // 分割路径
    const encodedParts = parts.map((part, index) => {
      // 只对最后一个部分（文件名）进行编码
      return index === parts.length - 1 ? encodeURIComponent(part) : part;
    });
    return `${this.baseURL}/${encodedParts.join('/')}`; // 重新拼接路径
  },
    /** 查询招聘信息列表 */
    getList() {
      this.loading = true;
      listJobapp(this.queryParams).then(response => {
        this.jobappList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        name: null,
        gender: null,
        age: null,
        phone: null,
        education: null,
        expectedSalary: null,
        positionApplied: null,
        jobStatus: null,
        workExperience: null,
        matchPercentage: null,
        riskAssessment: null,
        riskSummaryUrl: null,
        resumeUrl: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加招聘信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getJobapp(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改招聘信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateJobapp(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addJobapp(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除招聘信息编号为"' + ids + '"的数据项？').then(function() {
        return delJobapp(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/jobapp/export', {
        ...this.queryParams
      }, `jobapp_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
