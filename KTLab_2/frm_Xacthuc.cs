using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace KTLab_2
{
    public partial class frm_Xacthuc : Form
    {
        public frm_Xacthuc()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (txtmatKhau.Text == "admin@123")
            {
                this.DialogResult = DialogResult.OK;
                this.Close();
            }
            else
            {
                MessageBox.Show("Xác thực thất bại!");
            }
        }

        private void frm_Xacthuc_Load(object sender, EventArgs e)
        {
            txtmatKhau.PasswordChar = '●';
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Hide();
        }
    }
}
