//package com.nyb.demo.netty;
//
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.channel.Channel;
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.ChannelPipeline;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//import io.netty.handler.codec.http.HttpObjectAggregator;
//import io.netty.handler.codec.http.HttpServerCodec;
//import org.springframework.stereotype.Service;
//
///**
// * @Author:nyb
// * @DESC:
// * @Date: Created in 16:22 2020/7/27
// * @Modified By:
// */
//@Service
//public class NettyServer {
//
//    public void run(int port){
//        new Thread(){
//            @Override
//            public void run() {
//
//            }
//        }.start();
//    }
//
//    private void runServer(int port) {
//        System.out.println("message服务端启动");
//        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
//        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
//        ServerBootstrap b = new ServerBootstrap();
//        b.group(bossGroup,workerGroup);
//        b.channel(NioServerSocketChannel.class);
//        b.childHandler(new ChannelInitializer<SocketChannel>() {
//            @Override
//            protected void initChannel(SocketChannel ch) throws Exception {
//                ChannelPipeline pipeline = ch.pipeline();
//                pipeline.addLast("codec-http",new HttpServerCodec());
//                pipeline.addLast("aggregator",new HttpObjectAggregator(65536));
//                pipeline.addLast("handler",MyWebSocketServerHandler());
//            }
//        });
//        try {
//            Channel channel = b.bind(port).sync().channel();
//            System.out.println("message服务启动成功"+ channel.toString());
//            channel.closeFuture().sync();
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            bossGroup.shutdownGracefully();
//            workerGroup.shutdownGracefully();
//            System.out.println("Message服务已关闭");
//        }
//    }
//
//}
