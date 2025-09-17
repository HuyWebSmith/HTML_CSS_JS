function timeSince(timeStamp) {
    let now = new Date();
    console.log(`Xem thu time stamp hien tai: ${now.getTime()}`);
    let timeDifference = now - timeStamp;

    let seconds = Math.floor(timeDifference / 1000);
    let minutes = Math.floor(seconds / 60);
    let hours = Math.floor(minutes / 60);
    let days = Math.floor(hours / 24);
    let months = Math.floor(days / 30);
    let years = Math.floor(months / 12);

    if (years > 0) {
        return `Hoạt động ${years} năm trước`;
    }else if (months > 0) {
        return `Hoạt động ${months} tháng trước`;
    }else if (days > 0) {
        return `Hoạt động ${days} ngày trước`;
    }else if (hours > 0) {
        return `Hoạt động ${hours} giờ trước`;
    }else if (minutes > 0) {
        return `Hoạt động ${minutes} phút trước`;
    }else {
        return `Hoạt động ${seconds} giây trước`;
    }
}

let timeOffline = 0 ; 
console.log(timeSince(timeOffline));