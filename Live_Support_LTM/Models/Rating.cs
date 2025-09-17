namespace Live_Support_LTM.Models
{
    public class Rating
    {
        public int Id { get; set; }
        public int Score { get; set; }
        public string Comment { get; set; }

        public int TicketId { get; set; }
        public Ticket Ticket { get; set; }
    }
}
