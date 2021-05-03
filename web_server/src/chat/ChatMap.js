let chatMap = new Map();

module.exports = {
    newChatMessage: function (message) {
        chatMap.set(chatMap.size, message);
    },
    getMap: function () {
      return chatMap;
    },
    removeChatMessage: function (messageID) {
        chatMap.delete(messageID);
    }
}