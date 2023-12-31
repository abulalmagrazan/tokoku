USE [master]
GO
/****** Object:  Database [Tokoku]    Script Date: 15/06/2023 14:34:50 ******/
CREATE DATABASE [Tokoku]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Tokoku', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Tokoku.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Tokoku_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Tokoku_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [Tokoku] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Tokoku].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Tokoku] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Tokoku] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Tokoku] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Tokoku] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Tokoku] SET ARITHABORT OFF 
GO
ALTER DATABASE [Tokoku] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Tokoku] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Tokoku] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Tokoku] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Tokoku] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Tokoku] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Tokoku] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Tokoku] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Tokoku] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Tokoku] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Tokoku] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Tokoku] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Tokoku] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Tokoku] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Tokoku] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Tokoku] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Tokoku] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Tokoku] SET RECOVERY FULL 
GO
ALTER DATABASE [Tokoku] SET  MULTI_USER 
GO
ALTER DATABASE [Tokoku] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Tokoku] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Tokoku] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Tokoku] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Tokoku] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Tokoku] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'Tokoku', N'ON'
GO
ALTER DATABASE [Tokoku] SET QUERY_STORE = OFF
GO
USE [Tokoku]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 15/06/2023 14:34:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[Username] [varchar](255) NOT NULL,
	[Password] [varchar](200) NOT NULL,
	[Role] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cart]    Script Date: 15/06/2023 14:34:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cart](
	[IdCustomer] [bigint] NOT NULL,
	[IdProduct] [bigint] NOT NULL,
	[Quantity] [int] NULL,
 CONSTRAINT [PK__Cart__DB43864AD7C66CF2] PRIMARY KEY CLUSTERED 
(
	[IdCustomer] ASC,
	[IdProduct] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 15/06/2023 14:34:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](50) NOT NULL,
	[description] [varchar](255) NULL,
	[img] [varchar](255) NULL,
 CONSTRAINT [PK__Categori__3214EC0712EF7CBE] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UQ_Categories_Name] UNIQUE NONCLUSTERED 
(
	[Name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CustomerAddress]    Script Date: 15/06/2023 14:34:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CustomerAddress](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[CustomerId] [bigint] NOT NULL,
	[Address] [varchar](100) NOT NULL,
	[City] [varchar](50) NOT NULL,
	[Phone] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Table_1] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customers]    Script Date: 15/06/2023 14:34:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customers](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[Username] [varchar](255) NOT NULL,
	[Password] [varchar](200) NOT NULL,
	[FirstName] [varchar](200) NOT NULL,
	[LastName] [varchar](200) NULL,
	[BirthDate] [date] NOT NULL,
	[Gender] [varchar](100) NOT NULL,
	[Phone] [varchar](20) NOT NULL,
	[RegisterDate] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UQ_Customers_Username] UNIQUE NONCLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Deliveries]    Script Date: 15/06/2023 14:34:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Deliveries](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[CompanyName] [varchar](100) NOT NULL,
	[Phone] [varchar](20) NOT NULL,
	[Cost] [money] NOT NULL,
 CONSTRAINT [PK_Deliveries] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetails]    Script Date: 15/06/2023 14:34:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetails](
	[Invoice] [varchar](20) NOT NULL,
	[idProduct] [bigint] NOT NULL,
	[Quantity] [int] NOT NULL,
	[Cost] [money] NOT NULL,
	[Discount] [money] NULL,
 CONSTRAINT [PK__OrderDet__6F2DFD0266A3B5B1] PRIMARY KEY CLUSTERED 
(
	[Invoice] ASC,
	[idProduct] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 15/06/2023 14:34:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[Invoice] [varchar](20) NOT NULL,
	[IdCustomer] [bigint] NOT NULL,
	[OrderDate] [date] NOT NULL,
	[ShippedDate] [date] NOT NULL,
	[DueDate] [date] NOT NULL,
	[ReceiveDate] [date] NULL,
	[description] [varchar](500) NULL,
PRIMARY KEY CLUSTERED 
(
	[Invoice] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 15/06/2023 14:34:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](500) NOT NULL,
	[IdShop] [bigint] NOT NULL,
	[IdCategory] [bigint] NOT NULL,
	[Description] [varchar](500) NULL,
	[Price] [money] NOT NULL,
	[Stock] [int] NULL,
	[Image] [varchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UQ_Product_Name] UNIQUE NONCLUSTERED 
(
	[Name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Sellers]    Script Date: 15/06/2023 14:34:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sellers](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[Username] [varchar](255) NOT NULL,
	[Password] [varchar](200) NOT NULL,
	[FirstName] [varchar](200) NOT NULL,
	[LastName] [varchar](200) NULL,
	[BirthDate] [date] NOT NULL,
	[Gender] [varchar](100) NOT NULL,
	[Phone] [varchar](20) NOT NULL,
	[RegisterDate] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UQ_Sellers_Username] UNIQUE NONCLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Shop]    Script Date: 15/06/2023 14:34:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Shop](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[IdSeller] [bigint] NOT NULL,
	[ShopName] [varchar](500) NOT NULL,
	[Detail] [varchar](250) NULL,
	[Address] [varchar](500) NOT NULL,
	[City] [varchar](100) NOT NULL,
	[RegisterDate] [date] NOT NULL,
	[ImagePath] [varchar](100) NULL,
	[DeleteDate] [date] NULL,
 CONSTRAINT [PK__Shop__3214EC07CD4724CC] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD  CONSTRAINT [FK_Cart_IdCustomer] FOREIGN KEY([IdCustomer])
REFERENCES [dbo].[Customers] ([Id])
GO
ALTER TABLE [dbo].[Cart] CHECK CONSTRAINT [FK_Cart_IdCustomer]
GO
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD  CONSTRAINT [FK_Cart_IdProduct] FOREIGN KEY([IdProduct])
REFERENCES [dbo].[Products] ([Id])
GO
ALTER TABLE [dbo].[Cart] CHECK CONSTRAINT [FK_Cart_IdProduct]
GO
ALTER TABLE [dbo].[CustomerAddress]  WITH CHECK ADD  CONSTRAINT [FK_CustomerAddress_Customers] FOREIGN KEY([CustomerId])
REFERENCES [dbo].[Customers] ([Id])
GO
ALTER TABLE [dbo].[CustomerAddress] CHECK CONSTRAINT [FK_CustomerAddress_Customers]
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_IdProduct] FOREIGN KEY([idProduct])
REFERENCES [dbo].[Products] ([Id])
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [FK_OrderDetail_IdProduct]
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetails_invoice] FOREIGN KEY([Invoice])
REFERENCES [dbo].[Orders] ([Invoice])
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [FK_OrderDetails_invoice]
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD  CONSTRAINT [FK_Order_IdCustomer] FOREIGN KEY([IdCustomer])
REFERENCES [dbo].[Customers] ([Id])
GO
ALTER TABLE [dbo].[Orders] CHECK CONSTRAINT [FK_Order_IdCustomer]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Product_IdCategory] FOREIGN KEY([IdCategory])
REFERENCES [dbo].[Categories] ([Id])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Product_IdCategory]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Product_IdShop] FOREIGN KEY([IdShop])
REFERENCES [dbo].[Shop] ([Id])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Product_IdShop]
GO
ALTER TABLE [dbo].[Shop]  WITH CHECK ADD  CONSTRAINT [FK_Shop_IdSeller] FOREIGN KEY([IdSeller])
REFERENCES [dbo].[Sellers] ([Id])
GO
ALTER TABLE [dbo].[Shop] CHECK CONSTRAINT [FK_Shop_IdSeller]
GO
/****** Object:  StoredProcedure [dbo].[ShopBySeller]    Script Date: 15/06/2023 14:34:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[ShopBySeller]
(@sellerName AS varchar(100),@shopName AS varchar(100))
AS
BEGIN

select CONCAT(se.FirstName, ' ',se.LastName) fullName, se.Phone,sh.ShopName,sh.City,CONCAT(sh.Address,', ',sh.City) [Address]  from Shop as sh
left join Sellers as se on se.Id=sh.IdSeller
where CONCAT(se.FirstName, ' ',se.LastName) like '%'+@sellerName+'%' or sh.ShopName like '%'+@shopName+'%'

END
GO
USE [master]
GO
ALTER DATABASE [Tokoku] SET  READ_WRITE 
GO
