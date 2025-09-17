using Live_Support_LTM.Models;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System;

namespace Live_Support_LTM.Areas.Customer.Controllers
{
    [Area("Customer")]
    [Authorize(Roles = "Customer")]
    public class ChatController : Controller
    {
        private readonly SupportContext _context;
        private readonly UserManager<ApplicationUser> _userManager;

        public ChatController(SupportContext context, UserManager<ApplicationUser> userManager)
        {
            _context = context;
            _userManager = userManager;
        }

        public async Task<IActionResult> CreateTicket()
        {
            var user = await _userManager.GetUserAsync(User);

            // Tạo mã phòng ngẫu nhiên
            string roomCode = Guid.NewGuid().ToString().Substring(0, 8).ToUpper();

            // Tạo ticket mới
            var ticket = new Ticket
            {
                CustomerId = user.Id,
                Status = "Waiting",
                Subject = "Hỗ trợ mới",
                RoomId = roomCode,
                CreatedAt = DateTime.Now // nếu có
            };

            _context.Tickets.Add(ticket);
            await _context.SaveChangesAsync();

            // Điều hướng tới phòng chat
            return RedirectToAction("ChatRoom", new { roomCode = ticket.RoomId });
        }


        public async Task<IActionResult> ChatRoom(string roomCode)
        {
            if (string.IsNullOrEmpty(roomCode))
            {
                return NotFound();
            }

            var ticket = await _context.Tickets
                
                .FirstOrDefaultAsync(t => t.RoomId == roomCode);

            if (ticket == null)
            {
                return NotFound();
            }

            ViewBag.RoomName = ticket.RoomId;
            return View(ticket);
        }

    }

}
