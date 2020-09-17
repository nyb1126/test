//package com.nyb.demo.netty;
//
//import com.alibaba.fastjson.JSONObject;
//import io.netty.buffer.ByteBuf;
//import io.netty.buffer.Unpooled;
//import io.netty.channel.*;
//import io.netty.handler.codec.http.DefaultFullHttpResponse;
//import io.netty.handler.codec.http.FullHttpRequest;
//import io.netty.handler.codec.http.HttpResponseStatus;
//import io.netty.handler.codec.http.HttpVersion;
//import io.netty.handler.codec.http.websocketx.*;
//import io.netty.util.CharsetUtil;
//
///**
// * @Author:nyb
// * @DESC:
// * @Date: Created in 16:35 2020/7/27
// * @Modified By:
// */
//public class MyWebSocketServerHandler extends SimpleChannelInboundHandler<Object> {
//
//    private static final String WEBSOCKET_PATH = "";
//    private WebSocketServerHandshaker handshaker;
//
//    @Override
//    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
//
//    }
//
//    @Override
//    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        ctx.flush();
//    }
//
//    private void handleHttpRequest(ChannelHandlerContext context, FullHttpRequest request) {
//        //要求upgrade为websocket，过滤掉get post
//        if (!request.decoderResult().isSuccess() || !"websocket".equals(request.headers().get("Upgrade"))) {
//            //若不是websocket，则创建bad request，返回给客户端
//            sendHttpResponse(context, request, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
//            return;
//        }
//        WebSocketServerHandshakerFactory factory = new WebSocketServerHandshakerFactory("ws://localhost:9502/websocket", null, false);
//        if (null == factory) {
//            WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(context.channel());
//        } else {
//            handshaker.handshake(context.channel(), request);
//        }
//
//    }
//
//    private void handleWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {
//        // Check for closing frame
//        if (frame instanceof CloseWebSocketFrame) {
//            handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
//            return;
//        }
//        if (frame instanceof PingWebSocketFrame) {
//            ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
//            return;
//        }
//        if (!(frame instanceof TextWebSocketFrame)) {
//            System.out.println("数据帧类型不支持!");
//        }
//
//        // Send the uppercase string back.
//        String request = ((TextWebSocketFrame) frame).text();
//        System.out.println("Netty服务器接收到的信息: " + request);
//        if (request.equals()) {
//            ctx.channel().write(new TextWebSocketFrame(request));
//            return;
//        }
//
//        JSONObject jsonData = JSONObject.parseObject(request);
//        String eventType = jsonData.getString("event_type");
//        String apiToken = jsonData.getString("api_token");
//        if ("".equals(eventType)) {
//            System.out.println("front event");
//            ChannelSupervise.updateChannel(apiToken, ctx.channel());
//        } else if ("".equals(eventType)) {
//            System.out.println("behind event");
//            Channel chan = ChannelSupervise.findChannel(apiToken);
//            if (null == chan) {
//                Print.error("目标用户不存在");
//            } else {
//                JSONObject jsonMsg = new JSONObject();
//                jsonMsg.put("type", jsonData.get("type"));
//                jsonMsg.put("child_type", jsonData.get("child_type"));
//                jsonMsg.put("title", jsonData.get("title"));
//                jsonMsg.put("body", jsonData.get("body"));
//                ChannelSupervise.sendToSimple(apiToken, new TextWebSocketFrame(jsonMsg.toString()));
//                System.out.println("向目标用户发送成功");
//            }
//        } else {
//            System.out.println("event type error");
//        }
//    }
//
//
//    private static void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest req, DefaultFullHttpResponse res) {
//        // 返回应答给客户端
//        if (res.status().code() != 200) {
//            ByteBuf buf = Unpooled.copiedBuffer(res.status().toString(),
//                    CharsetUtil.UTF_8);
//            res.content().writeBytes(buf);
//            buf.release();
//        }
//        ChannelFuture f = ctx.channel().writeAndFlush(res);
//        // 如果是非Keep-Alive，关闭连接
//        if (!isKeepAlive(req) || res.status().code() != 200) {
//            f.addListener(ChannelFutureListener.CLOSE);
//        }
//    }
//
//
//}
