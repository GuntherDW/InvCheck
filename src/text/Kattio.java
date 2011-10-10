package text;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Kattio extends PrintWriter {

   private BufferedReader r;
   private String line;
   private StringTokenizer st;
   private String token;


   public Kattio(InputStream i) {
      super(new BufferedOutputStream(System.out));
      this.r = new BufferedReader(new InputStreamReader(i));
   }

   public Kattio(InputStream i, OutputStream o) {
      super(new BufferedOutputStream(o));
      this.r = new BufferedReader(new InputStreamReader(i));
   }

   public boolean hasMoreTokens() {
      return this.peekToken() != null;
   }

   public int getInt() {
      return Integer.parseInt(this.nextToken());
   }

   public double getDouble() {
      return Double.parseDouble(this.nextToken());
   }

   public long getLong() {
      return Long.parseLong(this.nextToken());
   }

   public String getWord() {
      return this.nextToken();
   }

   private String peekToken() {
      if(this.token == null) {
         try {
            while(this.st == null || !this.st.hasMoreTokens()) {
               this.line = this.r.readLine();
               if(this.line == null) {
                  return null;
               }

               this.st = new StringTokenizer(this.line);
            }

            this.token = this.st.nextToken();
         } catch (IOException var2) {
            ;
         }
      }

      return this.token;
   }

   private String nextToken() {
      String ans = this.peekToken();
      this.token = null;
      return ans;
   }
}
