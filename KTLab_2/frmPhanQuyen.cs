using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.Entity.Validation;

namespace KTLab_2
{
    public partial class frmPhanQuyen : Form
    {
        public frmPhanQuyen()
        {
            InitializeComponent();
        }

        private void dgv_QuanLy_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex >= 0 && e.ColumnIndex == dgv_QuanLy.Columns["colHaQuyen"].Index)
            {
                var f = new frm_Xacthuc();
                if (f.ShowDialog() == DialogResult.OK)
                {
                    string tenDangNhap = dgv_QuanLy.Rows[e.RowIndex].Cells["TENDANGNHAP"].Value.ToString();
                    UpdateRole(tenDangNhap, false); // Hạ quyền
                }
            }
        }

        private void AddActionButtons()
        {
            // Nếu đã có cột, không thêm lại (tránh lỗi trùng lặp)
            if (dgv_QuanLy.Columns["colHaQuyen"] == null)
            {
                DataGridViewButtonColumn btnDown = new DataGridViewButtonColumn();
                btnDown.Name = "colHaQuyen";             // Đặt tên cột dùng trong code
                btnDown.HeaderText = "Thay đổi";         // Hiển thị trên lưới
                btnDown.Text = "⇩";
                btnDown.UseColumnTextForButtonValue = true;
                dgv_QuanLy.Columns.Add(btnDown);
            }

            if (dgv_banHang.Columns["colTangQuyen"] == null)
            {
                DataGridViewButtonColumn btnUp = new DataGridViewButtonColumn();
                btnUp.Name = "colTangQuyen";
                btnUp.HeaderText = "Thay đổi";
                btnUp.Text = "⇧";
                btnUp.UseColumnTextForButtonValue = true;
                dgv_banHang.Columns.Add(btnUp);
            }
        }

        private void UpdateRole(string tenDangNhap, bool laQuanLy)
        {
            using (var db = new QuanLyUserEntities1())
            {
                var nv = db.NHAN_VIEN.FirstOrDefault(n => n.TENDANGNHAP == tenDangNhap);
                if (nv != null)
                {
                    nv.LAQUANLY = laQuanLy;
                    try
                    {
                        db.SaveChanges();
                    }
                    catch (DbEntityValidationException ex)
                    {
                        foreach (var validationError in ex.EntityValidationErrors)
                        {
                            foreach (var error in validationError.ValidationErrors)
                            {
                                Console.WriteLine($"Property: {error.PropertyName}, Error: {error.ErrorMessage}");
                            }
                        }
                    }
                }
            }

            LoadData(); 
        }

        private void LoadData()
        {
            using (var db = new QuanLyUserEntities1())
            {
                var danhSachQuanLy = db.NHAN_VIEN
                    .Where(nv => nv.LAQUANLY == true)
                    .Select(nv => new
                    {
                        nv.TENDANGNHAP,
                        nv.MATKHAU,
                        nv.TENNHANVIEN,
                        nv.SDT,
                        nv.GIOITINH,
                        nv.NGAYSINH
                    }).ToList();

                dgv_QuanLy.DataSource = danhSachQuanLy;

                var danhSachBanHang = db.NHAN_VIEN
                    .Where(nv => nv.LAQUANLY == false)
                    .Select(nv => new
                    {
                        nv.TENDANGNHAP,
                        nv.MATKHAU,
                        nv.TENNHANVIEN,
                        nv.SDT,
                        nv.GIOITINH,
                        nv.NGAYSINH
                    }).ToList();

                dgv_banHang.DataSource = danhSachBanHang;
            }
        }

        private void frmPhanQuyen_Load(object sender, EventArgs e)
        {
            QuanLyUserEntities1 db = new QuanLyUserEntities1();

            var danhSachQuanLy = db.NHAN_VIEN
                .Where(nv => nv.LAQUANLY == true)
                .Select(nv => new
                {
                    nv.TENDANGNHAP,
                    nv.MATKHAU,
                    nv.TENNHANVIEN,
                    nv.SDT,
                    nv.GIOITINH,
                    nv.NGAYSINH
                })
                .ToList();

            var danhSachBanHang = db.NHAN_VIEN
                .Where(nv => nv.LAQUANLY == false)
                .Select(nv => new
                {
                    nv.TENDANGNHAP,
                    nv.MATKHAU,
                    nv.TENNHANVIEN,
                    nv.SDT,
                    nv.GIOITINH,
                    nv.NGAYSINH
                })
                .ToList();
            AddActionButtons();
            dgv_QuanLy.DataSource = danhSachQuanLy;
            dgv_banHang.DataSource = danhSachBanHang;

        }

        private void dgv_banHang_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex >= 0 && e.ColumnIndex == dgv_banHang.Columns["colTangQuyen"].Index)
            {
                var f = new frm_Xacthuc();
                if (f.ShowDialog() == DialogResult.OK)
                {
                    string tenDangNhap = dgv_banHang.Rows[e.RowIndex].Cells["TENDANGNHAP"].Value.ToString();
                    UpdateRole(tenDangNhap, true); // Tăng quyền
                }
            }
        }
    }
}
