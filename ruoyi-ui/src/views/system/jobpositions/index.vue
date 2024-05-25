<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="岗位" prop="positionName">
        <el-select v-model="queryParams.positionName" placeholder="请选择岗位" clearable>
          <el-option
            v-for="dict in dict.type.sys_job_want"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="招聘状态" prop="recruitmentStatus">
        <el-select v-model="queryParams.recruitmentStatus" placeholder="请选择招聘状态" clearable>
          <el-option
            v-for="dict in dict.type.sys_recruitmentstatus"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="所属部门" prop="department">
        <el-select v-model="queryParams.department" placeholder="请选择所属部门" clearable>
          <el-option
            v-for="dict in dict.type.sys_department"
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
          v-hasPermi="['system:jobpositions:add']"
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
          v-hasPermi="['system:jobpositions:edit']"
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
          v-hasPermi="['system:jobpositions:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:jobpositions:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="jobpositionsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="岗位" align="center" prop="positionName">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_job_want" :value="scope.row.positionName"/>
        </template>
      </el-table-column>
      <el-table-column label="发布状态" align="center" prop="recruitmentStatus">
  <template slot-scope="scope">
    <!-- 显示标签，非编辑状态 -->
    <div v-if="editingRow !== scope.row.userId">
      <dict-tag :options="dict.type.sys_recruitmentstatus" :value="scope.row.recruitmentStatus" @click.native="editRecruitmentStatus(scope.row)"/>
    </div>
    <!-- 编辑状态，显示下拉选择 -->
    <el-select v-else v-model="scope.row.recruitmentStatus" placeholder="请选择招聘状态"
               @change="updateRecruitmentStatus(scope.row, $event)"
               >
      <el-option
        v-for="dict in dict.type.sys_recruitmentstatus"
        :key="dict.value"
        :label="dict.label"
        :value="dict.value">
      </el-option>
    </el-select>
  </template>
</el-table-column>

      <el-table-column label="所属部门" align="center" prop="department">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_department" :value="scope.row.department"/>
        </template>
      </el-table-column>
      <el-table-column label="岗位描述" align="center" prop="positionDescription" />
      <el-table-column label="岗位职责" align="center" prop="positionResponsibilities" />
      <el-table-column label="附件" align="center" prop="attachmentUrl">
  <template slot-scope="scope">
    <!-- 只有当 attachmentUrl 存在且不为空时，才显示链接 -->
    <a v-if="scope.row.attachmentUrl" :href="getFullURL(scope.row.attachmentUrl)" target="_blank" title="点击查看">
      查看附件
    </a>
    <!-- 可选：如果没有附件，显示提示信息 -->
    <span v-else>无</span>
  </template>
</el-table-column>

      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:jobpositions:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:jobpositions:remove']"
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

    <!-- 添加或修改职位管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="岗位" prop="positionName">
          <el-select v-model="form.positionName" placeholder="请选择岗位">
            <el-option
              v-for="dict in dict.type.sys_job_want"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="招聘状态" prop="recruitmentStatus">
          <el-select v-model="form.recruitmentStatus" placeholder="请选择招聘状态">
            <el-option
              v-for="dict in dict.type.sys_recruitmentstatus"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="所属部门" prop="department">
          <el-select v-model="form.department" placeholder="请选择所属部门">
            <el-option
              v-for="dict in dict.type.sys_department"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="岗位描述" prop="positionDescription">
          <el-input v-model="form.positionDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="岗位职责" prop="positionResponsibilities">
          <el-input v-model="form.positionResponsibilities" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="附件" prop="attachmentUrl">
          <file-upload v-model="form.attachmentUrl"/>
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
import { listJobpositions, getJobpositions, delJobpositions, addJobpositions, updateJobpositions } from "@/api/system/jobpositions";

export default {
  name: "Jobpositions",
  dicts: ['sys_job_want', 'sys_recruitmentstatus', 'sys_department'],
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
      // 职位管理表格数据
      jobpositionsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        positionName: null,
        recruitmentStatus: null,
        department: null,
        positionDescription: null,
        positionResponsibilities: null,
        attachmentUrl: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        positionName: [
          { required: true, message: "岗位不能为空", trigger: "change" }
        ],
        recruitmentStatus: [
          { required: true, message: "招聘状态不能为空", trigger: "change" }
        ],
        department: [
          { required: true, message: "所属部门不能为空", trigger: "change" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    
  editRecruitmentStatus(row) {
    this.editingRow = row.userId; // 设置为编辑状态
  },
  updateRecruitmentStatus(row, newValue) {
    const oldStatus = row.recruitmentStatus;
    const index = this.jobpositionsList.findIndex(item => item.userId === row.userId);
    if (index !== -1) {
      updateJobpositions({...row, recruitmentStatus: newValue}).then(response => {
        // 使用Vue.set来确保视图可以响应状态的更新
        this.$set(this.jobpositionsList[index], 'recruitmentStatus', newValue);
        this.$modal.msgSuccess("状态更新成功");
        this.editingRow = null; // 重置正在编辑的行
      }).catch(error => {
        this.$set(this.jobpositionsList[index], 'recruitmentStatus', oldStatus); // 出错时回滚到旧状态
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
    /** 查询职位管理列表 */
    getList() {
      this.loading = true;
      listJobpositions(this.queryParams).then(response => {
        this.jobpositionsList = response.rows;
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
        positionName: null,
        recruitmentStatus: null,
        department: null,
        positionDescription: null,
        positionResponsibilities: null,
        attachmentUrl: null
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
      this.title = "添加职位管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getJobpositions(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改职位管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateJobpositions(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addJobpositions(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除职位管理编号为"' + ids + '"的数据项？').then(function() {
        return delJobpositions(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/jobpositions/export', {
        ...this.queryParams
      }, `jobpositions_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
