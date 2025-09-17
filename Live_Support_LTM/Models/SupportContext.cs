using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore;

namespace Live_Support_LTM.Models
{
    public class SupportContext : IdentityDbContext<ApplicationUser>
    {
        public SupportContext(DbContextOptions<SupportContext> options) : base(options) { }
   

        public DbSet<Department> Departments { get; set; }
        public DbSet<Ticket> Tickets { get; set; }
        public DbSet<Message> Messages { get; set; }
        public DbSet<Rating> Ratings { get; set; }
        public DbSet<Attachment> Attachments { get; set; }
        public DbSet<ChatRoom> ChatRooms { get; set; }
        public DbSet<SessionLog> SessionLogs { get; set; }
    }
}
