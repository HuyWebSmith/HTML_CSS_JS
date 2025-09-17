namespace Live_Support_LTM.Models
{
    public class Attachment
    {
        public int Id { get; set; }
        public string FileName { get; set; }
        public string FilePath { get; set; }
        public DateTime UploadedAt { get; set; }

        public int MessageId { get; set; }
        public Message Message { get; set; }
    }
}
