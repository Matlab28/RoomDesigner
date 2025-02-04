fetch("/api/room/edit", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
        imageBase64: "data:image/png;base64,...", // Room image
        maskBase64: "data:image/png;base64,...", // Area to modify
        prompt: "Add a modern sofa"
    })
})
    .then(response => response.json())
    .then(data => {
        document.getElementById("resultImage").src = data.url; // Display edited room
    });
