package com.house.demo.system;

import java.util.Map;

public interface SystemService {
      public void deleteCache(String folder);
      public Map<String,Boolean> contentService();
      public Map<String,String> chatService();
}
