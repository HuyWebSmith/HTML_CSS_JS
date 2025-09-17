using System.Net.Mail;

namespace Live_Support_LTM.Models
{
    public class Message
    {
        public int Id { get; set; }
        public string Sender { get; set; }
        public string Content { get; set; }
        public DateTime SentAt { get; set; }

        public int TicketId { get; set; }
        public Ticket Ticket { get; set; }

        public int? ChatRoomId { get; set; }
        public ChatRoom ChatRoom { get; set; }

        public ICollection<Attachment> Attachments { get; set; }
    }
}
