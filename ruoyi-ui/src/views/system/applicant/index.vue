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
      <el-form-item label="学历" prop="education">
        <el-input
          v-model="queryParams.education"
          placeholder="请输入学历"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="期望工资" prop="expectedSalary">
        <el-input
          v-model="queryParams.expectedSalary"
          placeholder="请输入期望工资"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="应聘职位" prop="positionApplied">
        <el-input
          v-model="queryParams.positionApplied"
          placeholder="请输入应聘职位"
          clearable
          @keyup.enter.native="handleQuery"
        />
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
      <el-form-item label="工作经验" prop="workExperience">
        <el-input
          v-model="queryParams.workExperience"
          placeholder="请输入工作经验"
          clearable
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['system:applicant:add']"
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
          v-hasPermi="['system:applicant:edit']"
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
          v-hasPermi="['system:applicant:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:applicant:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="applicantList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="用户ID" align="center" prop="userId" />
      <el-table-column label="姓名" align="center" prop="name" />
      <el-table-column label="头像" align="center" prop="avatarUrl" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.avatarUrl" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="性别" align="center" prop="gender">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_user_sex" :value="scope.row.gender"/>
        </template>
      </el-table-column>
      <el-table-column label="年龄" align="center" prop="age" />
      <el-table-column label="电话号码" align="center" prop="phone" />
      <el-table-column label="学历" align="center" prop="education" />
      <el-table-column label="期望工资" align="center" prop="expectedSalary" />
      <el-table-column label="应聘职位" align="center" prop="positionApplied" />
      <el-table-column label="求职状态" align="center" prop="jobStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_job_applicants" :value="scope.row.jobStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="工作经验" align="center" prop="workExperience" />
      
      <el-table-column label="简历" align="center" prop="resumeUrl">
  <template slot-scope="scope">
    <!-- 使用 getFullURL 方法生成正确的 URL -->
    <a :href="getFullURL(scope.row.resumeUrl)" target="_blank" title="点击查看简历">
      查看简历
    </a>
  </template>
</el-table-column>

      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:applicant:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:applicant:remove']"
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
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="头像" prop="avatarUrl">
          <image-upload v-model="form.avatarUrl"/>
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
        <el-form-item label="电话号码" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入电话号码" />
        </el-form-item>
        <el-form-item label="学历" prop="education">
          <el-input v-model="form.education" placeholder="请输入学历" />
        </el-form-item>
        <el-form-item label="期望工资" prop="expectedSalary">
          <el-input v-model="form.expectedSalary" placeholder="请输入期望工资" />
        </el-form-item>
        <el-form-item label="应聘职位" prop="positionApplied">
          <el-input v-model="form.positionApplied" placeholder="请输入应聘职位" />
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
          <el-input v-model="form.workExperience" placeholder="请输入工作经验" />
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
import { listApplicant, getApplicant, delApplicant, addApplicant, updateApplicant } from "@/api/system/applicant";

export default {
  name: "Applicant",
  dicts: ['sys_user_sex', 'sys_job_applicants'],
  data() {
    return {
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
      // 应聘表格数据
      applicantList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        avatarUrl: null,
        gender: null,
        age: null,
        education: null,
        expectedSalary: null,
        positionApplied: null,
        jobStatus: null,
        workExperience: null,
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
    getFullURL(relativePath) {
    const parts = relativePath.split('/'); // 分割路径
    const encodedParts = parts.map((part, index) => {
      // 只对最后一个部分（文件名）进行编码
      return index === parts.length - 1 ? encodeURIComponent(part) : part;
    });
    return `${this.baseURL}/${encodedParts.join('/')}`; // 重新拼接路径
  },
    /** 查询应聘列表 */
    getList() {
      this.loading = true;
      listApplicant(this.queryParams).then(response => {
        this.applicantList = response.rows;
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
        userId: null,
        name: null,
        avatarUrl: null,
        gender: null,
        age: null,
        phone: null,
        education: null,
        expectedSalary: null,
        positionApplied: null,
        jobStatus: null,
        workExperience: null,
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
      this.ids = selection.map(item => item.userId)
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
      const userId = row.userId || this.ids
      getApplicant(userId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改应聘";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.userId != null) {
            updateApplicant(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addApplicant(this.form).then(response => {
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
      const userIds = row.userId || this.ids;
      this.$modal.confirm('是否确认删除应聘编号为"' + userIds + '"的数据项？').then(function() {
        return delApplicant(userIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/applicant/export', {
        ...this.queryParams
      }, `applicant_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>