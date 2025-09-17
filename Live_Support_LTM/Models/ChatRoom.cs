namespace Live_Support_LTM.Models
{
    public class ChatRoom
    {
        public int Id { get; set; }
        public string RoomCode { get; set; }
        public DateTime CreatedAt { get; set; }
        public string CustomerId { get; set; }
        public string? SupporterId { get; set; }
        public int TicketId { get; set; }
        public Ticket Ticket { get; set; }

        public ICollection<Message> Messages { get; set; }
    }
}
