<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="姓名" prop="UserName">
        <el-input
          v-model="queryParams.UserName"
          placeholder="请输入姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别" prop="Gender">
        <el-select v-model="queryParams.Gender" placeholder="请选择性别" clearable>
          <el-option
            v-for="dict in dict.type.sys_user_sex"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="年龄" prop="Age">
        <el-input
          v-model="queryParams.Age"
          placeholder="请输入年龄"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="电话" prop="Phone">
        <el-input
          v-model="queryParams.Phone"
          placeholder="请输入电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学历" prop="Education">
        <el-select v-model="queryParams.Education" placeholder="请选择学历" clearable>
          <el-option
            v-for="dict in dict.type.sys_education"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="期望工资" prop="ExpectedSalary">
        <el-select v-model="queryParams.ExpectedSalary" placeholder="请选择期望工资" clearable>
          <el-option
            v-for="dict in dict.type.sys_money"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="应聘职位" prop="AppliedPosition">
        <el-select v-model="queryParams.AppliedPosition" placeholder="请选择应聘职位" clearable>
          <el-option
            v-for="dict in dict.type.sys_job_want"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="求职状态" prop="JobStatus">
        <el-select v-model="queryParams.JobStatus" placeholder="请选择求职状态" clearable>
          <el-option
            v-for="dict in dict.type.sys_job_applicants"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="工作经验" prop="WorkExperience">
        <el-input
          v-model="queryParams.WorkExperience"
          placeholder="请输入工作经验"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="匹配度" prop="MatchScore">
        <el-input
          v-model="queryParams.MatchScore"
          placeholder="请输入匹配度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="风险评估" prop="RiskAssessment">
        <el-select v-model="queryParams.RiskAssessment" placeholder="请选择风险评估" clearable>
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
          v-hasPermi="['system:recruit:add']"
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
          v-hasPermi="['system:recruit:edit']"
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
          v-hasPermi="['system:recruit:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:recruit:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="recruitList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="UserID" />
      <el-table-column label="姓名" align="center" prop="UserName" />
      <el-table-column label="性别" align="center" prop="Gender">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_user_sex" :value="scope.row.Gender"/>
        </template>
      </el-table-column>
      <el-table-column label="年龄" align="center" prop="Age" />
      <el-table-column label="电话" align="center" prop="Phone" />
      <el-table-column label="学历" align="center" prop="Education">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_education" :value="scope.row.Education"/>
        </template>
      </el-table-column>
      <el-table-column label="期望工资" align="center" prop="ExpectedSalary">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_money" :value="scope.row.ExpectedSalary"/>
        </template>
      </el-table-column>
      <el-table-column label="应聘职位" align="center" prop="AppliedPosition">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_job_want" :value="scope.row.AppliedPosition"/>
        </template>
      </el-table-column>
      <el-table-column label="求职状态" align="center" prop="JobStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_job_applicants" :value="scope.row.JobStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="工作经验" align="center" prop="WorkExperience" />
      <el-table-column label="匹配度" align="center" prop="MatchScore" />
      <el-table-column label="风险评估" align="center" prop="RiskAssessment">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_risk" :value="scope.row.RiskAssessment"/>
        </template>
      </el-table-column>
      <el-table-column label="风险概要" align="center" prop="AnalysisSummaryURL" />
      <el-table-column label="简历" align="center" prop="ResumeURL" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:recruit:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:recruit:remove']"
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

    <!-- 添加或修改应聘对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="姓名" prop="UserName">
          <el-input v-model="form.UserName" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="性别" prop="Gender">
          <el-select v-model="form.Gender" placeholder="请选择性别">
            <el-option
              v-for="dict in dict.type.sys_user_sex"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="年龄" prop="Age">
          <el-input v-model="form.Age" placeholder="请输入年龄" />
        </el-form-item>
        <el-form-item label="电话" prop="Phone">
          <el-input v-model="form.Phone" placeholder="请输入电话" />
        </el-form-item>
        <el-form-item label="学历" prop="Education">
          <el-select v-model="form.Education" placeholder="请选择学历">
            <el-option
              v-for="dict in dict.type.sys_education"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="期望工资" prop="ExpectedSalary">
          <el-select v-model="form.ExpectedSalary" placeholder="请选择期望工资">
            <el-option
              v-for="dict in dict.type.sys_money"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="应聘职位" prop="AppliedPosition">
          <el-select v-model="form.AppliedPosition" placeholder="请选择应聘职位">
            <el-option
              v-for="dict in dict.type.sys_job_want"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="求职状态" prop="JobStatus">
          <el-select v-model="form.JobStatus" placeholder="请选择求职状态">
            <el-option
              v-for="dict in dict.type.sys_job_applicants"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="工作经验" prop="WorkExperience">
          <el-input v-model="form.WorkExperience" placeholder="请输入工作经验" />
        </el-form-item>
        <el-form-item label="匹配度" prop="MatchScore">
          <el-input v-model="form.MatchScore" placeholder="请输入匹配度" />
        </el-form-item>
        <el-form-item label="风险评估" prop="RiskAssessment">
          <el-select v-model="form.RiskAssessment" placeholder="请选择风险评估">
            <el-option
              v-for="dict in dict.type.sys_risk"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="风险概要" prop="AnalysisSummaryURL">
          <file-upload v-model="form.AnalysisSummaryURL"/>
        </el-form-item>
        <el-form-item label="简历" prop="ResumeURL">
          <file-upload v-model="form.ResumeURL"/>
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
import { listRecruit, getRecruit, delRecruit, addRecruit, updateRecruit } from "@/api/system/recruit";

export default {
  name: "Recruit",
  dicts: ['sys_job_want', 'sys_education', 'sys_risk', 'sys_money', 'sys_user_sex', 'sys_job_applicants'],
  data() {
    return {
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
      // 应聘表格数据
      recruitList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        UserName: null,
        Gender: null,
        Age: null,
        Phone: null,
        Education: null,
        ExpectedSalary: null,
        AppliedPosition: null,
        JobStatus: null,
        WorkExperience: null,
        MatchScore: null,
        RiskAssessment: null,
        AnalysisSummaryURL: null,
        ResumeURL: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        UserName: [
          { required: true, message: "姓名不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询应聘列表 */
    getList() {
      this.loading = true;
      listRecruit(this.queryParams).then(response => {
        this.recruitList = response.rows;
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
        UserID: null,
        UserName: null,
        Gender: null,
        Age: null,
        Phone: null,
        Education: null,
        ExpectedSalary: null,
        AppliedPosition: null,
        JobStatus: null,
        WorkExperience: null,
        MatchScore: null,
        RiskAssessment: null,
        AnalysisSummaryURL: null,
        ResumeURL: null
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
      this.ids = selection.map(item => item.UserID)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加应聘";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const UserID = row.UserID || this.ids
      getRecruit(UserID).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改应聘";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.UserID != null) {
            updateRecruit(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addRecruit(this.form).then(response => {
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
      const UserIDs = row.UserID || this.ids;
      this.$modal.confirm('是否确认删除应聘编号为"' + UserIDs + '"的数据项？').then(function() {
        return delRecruit(UserIDs);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/recruit/export', {
        ...this.queryParams
      }, `recruit_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
