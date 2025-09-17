using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace KTLab_2
{
    public partial class FrmDangNhap : Form
    {
        public FrmDangNhap()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void FrmDangNhap_Load(object sender, EventArgs e)
        {
            txt_Matkhau.PasswordChar = '●';
        }

        private void btn_Dangnhap_Click(object sender, EventArgs e)
        {
            string tenDangNhap = txt_Tendangnhap.Text.Trim();
            string matKhau = txt_Matkhau.Text;

            if (string.IsNullOrEmpty(tenDangNhap) || string.IsNullOrEmpty(matKhau))
            {
                MessageBox.Show("Vui lòng nhập đầy đủ thông tin đăng nhập.");
                return;
            }

            string matKhauMaHoa = MaHoaSHA256(matKhau); 

            using (var db = new QuanLyUserEntities1())
            {
                var nhanVien = db.NHAN_VIEN
                                 .FirstOrDefault(nv => nv.TENDANGNHAP == tenDangNhap);

                if (nhanVien != null && nhanVien.MATKHAU == matKhauMaHoa) 
                {
                    MessageBox.Show("Đăng nhập thành công!", "Thông báo");
                    this.Hide();
                    new frmPhanQuyen().Show();
                }
                else
                {
                    MessageBox.Show("Tên đăng nhập hoặc mật khẩu không đúng.", "Lỗi", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }
        public static string MaHoaSHA256(string matKhau)
        {
            using (SHA256 sha256 = SHA256.Create())
            {
                byte[] bytes = Encoding.UTF8.GetBytes(matKhau);
                byte[] hash = sha256.ComputeHash(bytes);

                // Chuyển thành chuỗi hex
                StringBuilder sb = new StringBuilder();
                foreach (byte b in hash)
                    sb.Append(b.ToString("x2"));

                return sb.ToString();
            }
        }
        private void button1_Click(object sender, EventArgs e)
        {

        }

        private void txt_Matkhau_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
