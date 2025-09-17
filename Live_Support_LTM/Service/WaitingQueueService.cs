using System.Collections.Concurrent;

namespace Live_Support_LTM.Service
{
    public class WaitingQueueService
    {
        private readonly ConcurrentQueue<string> _queue = new();

        public void Enqueue(string connectionId) => _queue.Enqueue(connectionId);

        public string Dequeue()
        {
            if (_queue.TryDequeue(out var connId))
                return connId;
            return null;
        }

        public bool IsEmpty() => _queue.IsEmpty;
    }
}
