namespace Live_Support_LTM.Models
{
    public class SessionLog
    {
        public int Id { get; set; }
        public int UserId { get; set; }

        public DateTime LoginTime { get; set; }
        public DateTime? LogoutTime { get; set; }
        public string IPAddress { get; set; }
    }
}
