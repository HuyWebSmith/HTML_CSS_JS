const connection = new signalR.HubConnectionBuilder()
    .withUrl("/chathub")
    .build();

let currentRoom = null;

connection.on("WaitingInQueue", () => {
    alert("Bạn đang trong hàng chờ. Vui lòng đợi...");
});

connection.on("AssignedToRoom", async (roomId) => {
    alert("Đã được gán phòng: " + roomId);
    currentRoom = roomId;
    document.getElementById("roomTitle").textContent = "Phòng: " + roomId;
    await connection.invoke("JoinRoom", roomId);
});

connection.on("ReceiveMessage", (user, message) => {
    appendMessage(user, message);
});

document.getElementById("sendButton").addEventListener("click", async () => {
    const user = "Bạn";
    const message = document.getElementById("messageInput").value;
    if (message.trim() === "" || currentRoom === null) return;
    await connection.invoke("SendMessage", currentRoom, user, message);
    appendMessage("Bạn", message);
    document.getElementById("messageInput").value = "";
});

function appendMessage(user, message) {
    const chat = document.getElementById("chatMessages");
    const msg = document.createElement("div");
    msg.textContent = `${user}: ${message}`;
    chat.appendChild(msg);
    chat.scrollTop = chat.scrollHeight;
}

connection.start();
