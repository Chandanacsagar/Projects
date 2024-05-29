// background.js
chrome.runtime.onMessage.addListener(function(request, sender, sendResponse) {
  if (request.action === "checkUrl") {
    fetch(request.url)
      .then(response => {
        if (response.ok) {
          sendResponse({ exists: true });
        } else {
          sendResponse({ exists: false });
        }
      })
      .catch(error => {
        console.error("Error checking URL:", error);
        sendResponse({ exists: false });
      });
    return true;
  }
});
