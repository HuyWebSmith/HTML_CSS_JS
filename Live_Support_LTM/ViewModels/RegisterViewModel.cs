namespace Live_Support_LTM.ViewModels
{
    public class RegisterViewModel
    {
        public string FullName { get; set; }
        public string Role { get; set; } // "Customer" or "Support"
        public string Email { get; set; }
        public string Password { get; set; }
    }
}
