using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace Live_Support_LTM.Controllers
{
    [Authorize]
    public class ChatController : Controller
    {
        public IActionResult Index(string roomId)
        {
            if (string.IsNullOrEmpty(roomId)) roomId = "default";
            ViewBag.RoomId = roomId;
            return View();
        }
    }
}
