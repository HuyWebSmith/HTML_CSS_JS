using System.ComponentModel.DataAnnotations.Schema;

namespace Live_Support_LTM.Models
{
    public class Ticket
    {
        public int Id { get; set; }
        public string Subject { get; set; }
        public string Status { get; set; }
        public DateTime CreatedAt { get; set; }
        

        

        public string CustomerId { get; set; }

        public string? SupporterId { get; set; }
  
        public string RoomId { get; set; }
        public bool IsClosed { get; set; }
        public ICollection<Message> Messages { get; set; }
        public Rating Rating { get; set; }
        public ICollection<ChatRoom> ChatRooms { get; set; }
    }
}
