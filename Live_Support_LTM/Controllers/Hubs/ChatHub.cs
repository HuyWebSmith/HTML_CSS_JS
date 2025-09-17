using Live_Support_LTM.Models;
using Live_Support_LTM.Service;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.SignalR;
using System;

namespace Live_Support_LTM.Controllers.Hubs
{
    public class ChatHub : Hub
    {
        private readonly SupportContext _context;

        public ChatHub(SupportContext context)
        {
            _context = context;
        }

        public async Task JoinRoom(string roomCode)
        {
            await Groups.AddToGroupAsync(Context.ConnectionId, roomCode);
        }

        public async Task SendMessageToRoom(string roomCode, string userId, string message)
        {
            // Lưu tin nhắn vào DB
            var ticket = _context.Tickets.FirstOrDefault(t => t.RoomId == roomCode);
            if (ticket != null)
            {
                _context.Messages.Add(new Message
                {
                    TicketId = ticket.Id,
                    Sender = userId,
                    Content = message
                });
                await _context.SaveChangesAsync();
            }

            await Clients.Group(roomCode).SendAsync("ReceiveMessage", userId, message);
        }
    }
}
